package com.kotlinsevilla.cookietinder

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    val cookieRepository = CookieRepository()
    lateinit var allCookies: List<Cookie> // TODO (explicar lateinit)
    var current: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        allCookies = cookieRepository.getAllCookies()

        loadNext()
    }

    fun onLike(view: View) {
        cookieRepository.like(allCookies[current])
        loadNext()
    }

    fun onDislike(view: View) {
        cookieRepository.dislike(allCookies[current])
        loadNext()
    }

    fun loadNext() {
        val cookieImageView = findViewById<ImageView>(R.id.cookieImage)
        val cookieName = findViewById<TextView>(R.id.cookieName)
        val cookieDescription = findViewById<TextView>(R.id.cookieDescription)

        val cookie = allCookies[current]
        cookieName.text = cookie.name
        cookieDescription.text = cookie.description

        current++ // TODO - control del final del array
    }


}
