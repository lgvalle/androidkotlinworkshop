package com.kotlinsevilla.cookietinder

class CookieRepository(private val allCookies: List<Cookie> = emptyList()) {

    private val liked = mutableListOf<Cookie>()
    private val disliked = mutableListOf<Cookie>()

    fun getAllCookies() = allCookies
        .filter { it.image != -1 }
        .map { it.copy(name = it.name.toCamelCase()) }
        .sortedBy { it.name }
        .distinct()

    fun like(cookie: Cookie) {
        liked.add(cookie)
    }

    fun dislike(cookie: Cookie) {
        disliked.add(cookie)
    }

    fun likedCookies(): List<Cookie> = liked

    fun dislikedCookies(): List<Cookie> = disliked

}

private fun String.toCamelCase(): String = split(' ').joinToString(" ") { it.capitalize() }
