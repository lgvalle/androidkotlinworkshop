package com.kotlinsevilla.cookietinder

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.kotlinsevilla.cookietinder.liked.LikedCookiesActivity

class MainActivity : AppCompatActivity() {

    lateinit var allCookies: List<Cookie> // TODO (explicar lateinit)
    private var current: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        allCookies = CookieRepository.getInstance().getAllCookies()

        loadNext()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.liked -> startActivity(Intent(this, LikedCookiesActivity::class.java))
            R.id.disliked -> startActivity(Intent(this, LikedCookiesActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

    fun onLike(view: View) {
        CookieRepository.getInstance().like(allCookies[current])
        loadNext()
    }

    fun onDislike(view: View) {
        CookieRepository.getInstance().dislike(allCookies[current])
        loadNext()
    }

    fun loadNext() {
        val cookieImageView = findViewById<ImageView>(R.id.cookieImage)
        val cookieName = findViewById<TextView>(R.id.cookieName)
        val cookieDescription = findViewById<TextView>(R.id.cookieDescription)

        val cookie = allCookies[current]
        cookieName.text = cookie.name
        cookieDescription.text = cookie.description

        // TODO - control del final del array
        if (allCookies.size > current) {
            current++
        }
    }


}
