package com.kotlinsevilla.cookietinder


object CookieRepository {

    private val liked = mutableListOf<Cookie>()
    private val disliked = mutableListOf<Cookie>()

    fun getAllCookies() = listOf(
        Cookie("Tosta Rica", "¿Qué quereis desayunar?"),
        Cookie("Oreo", "Interesada en el cine de acción"),
        Cookie("Maria Dorada", "Le gusta tomar el sol y pasear por la playa")
    )

    fun like(cookie: Cookie) {
        liked.add(cookie)
    }

    fun dislike(cookie: Cookie) {
        disliked.add(cookie)
    }

    fun likedCookies(): List<Cookie> {
        return liked
    }

    fun dislikedCookies(): List<Cookie> {
        return disliked
    }
}
