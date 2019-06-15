package com.kotlinsevilla.cookietinder

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cookieName = findViewById<TextView>(R.id.cookieName)
        val cookieDescription = findViewById<TextView>(R.id.cookieDescription)
        val cookieImage = findViewById<ImageView>(R.id.cookieImage)
        val likeButton = findViewById<Button>(R.id.likeButton)
        val dislikeButton = findViewById<Button>(R.id.dislikeButton)

        cookieName.text = "Oreo"
        cookieDescription.text = "Likes sandwiches and chocolate"
        cookieImage.setImageResource(R.drawable.cookie_oreo)

        likeButton.setOnClickListener { Toast.makeText(this, "Like clicked!", Toast.LENGTH_SHORT).show() }
        dislikeButton.setOnClickListener { Toast.makeText(this, "Dislike clicked!", Toast.LENGTH_SHORT).show() }
    }

}
