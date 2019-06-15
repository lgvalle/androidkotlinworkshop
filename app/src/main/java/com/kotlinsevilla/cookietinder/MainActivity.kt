package com.kotlinsevilla.cookietinder

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val cookieRepository = CookieRepository(
        listOf(
            Cookie("Oreo", "Likes sandwiches and chocolate", R.drawable.cookie_oreo),
            Cookie("Maria", "Enjoys the Sun and lying on the beach", R.drawable.cookie_maria),
            Cookie("Chips Ahoy", "Favourite Saturday plan: long milk bath", R.drawable.cookie_chips_ahoy),
            Cookie("Filipinos", "Always with friends, you can't hang out only with one", R.drawable.cookie_filipinos)
        )
    )

    private val allCookies = cookieRepository.getAllCookies()
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cookieName = findViewById<TextView>(R.id.cookieName)
        val cookieDescription = findViewById<TextView>(R.id.cookieDescription)
        val cookieImage = findViewById<ImageView>(R.id.cookieImage)
        val likeButton = findViewById<Button>(R.id.likeButton)
        val dislikeButton = findViewById<Button>(R.id.dislikeButton)

        val bindUI = { cookie: Cookie ->
            cookieName.text = cookie.name
            cookieDescription.text = cookie.description
            cookieImage.setImageResource(cookie.image)
        }

        likeButton.setOnClickListener {
            allCookies[index].apply {
                Toast.makeText(this@MainActivity, "Like ${this.name}", Toast.LENGTH_SHORT).show()
                cookieRepository.like(this)
            }
            bindUI(allCookies[++index])
        }
        dislikeButton.setOnClickListener {
            allCookies[index].apply {
                Toast.makeText(this@MainActivity, "Dislike ${this.name}", Toast.LENGTH_SHORT).show()
                cookieRepository.dislike(this)
            }
            bindUI(allCookies[++index])
        }

        bindUI(allCookies[index])
    }

}
