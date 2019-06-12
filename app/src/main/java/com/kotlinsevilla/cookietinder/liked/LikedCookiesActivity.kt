package com.kotlinsevilla.cookietinder.liked

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kotlinsevilla.cookietinder.CookieRepository
import com.kotlinsevilla.cookietinder.R

class LikedCookiesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liked_cookies)

        val likedCookies = CookieRepository.getInstance().likedCookies()

        val viewAdapter = MyAdapter(likedCookies)

        findViewById<RecyclerView>(R.id.liked_cookies_recycler_view).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = LinearLayoutManager(this@LikedCookiesActivity)

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }
    }


}
