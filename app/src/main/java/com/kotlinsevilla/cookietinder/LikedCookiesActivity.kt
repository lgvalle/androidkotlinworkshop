package com.kotlinsevilla.cookietinder

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LikedCookiesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liked_cookies)

        val likedCookies = CookieRepository.likedCookies()

        val container = findViewById<LinearLayout>(R.id.liked_cookies_container)
        for (likedCookie in likedCookies) {
            val textView = TextView(this)
            container.addView(textView)
        }
    }
}
