package com.kotlinsevilla.cookietinder

class CookieRepository(private val allCookies: List<Cookie> = emptyList()) {

    private val liked = mutableListOf<Cookie>()
    private val disliked = mutableListOf<Cookie>()

    fun getAllCookies() = allCookies

    fun like(cookie: Cookie) {
        liked.add(cookie)
    }

    fun dislike(cookie: Cookie) {
        disliked.add(cookie)
    }

    fun likedCookies(): List<Cookie> = liked

    fun dislikedCookies(): List<Cookie> = disliked

}
