package com.kotlinsevilla.cookietinder


class CookieRepository {

    private val liked = mutableListOf<Cookie>()
    private val disliked = mutableListOf<Cookie>()

    fun getAllCookies(predicate: (Cookie) -> Boolean = { true }): List<Cookie> {
        val listOf = listOf(
            Cookie("Tosta Rica", "¿Qué quereis desayunar?"),
            Cookie("Tosta Rica Like 1", "¿Qué quereis desayunar?"),
            Cookie("Tosta Rica Like 2", "¿Qué quereis desayunar?"),
            Cookie("Tosta Rica Like 3", "¿Qué quereis desayunar?"),
            Cookie("Tosta Rica Like 4", "¿Qué quereis desayunar?"),
            Cookie("Tosta Rica DISLike 1", "¿Qué quereis desayunar?"),
            Cookie("Tosta Rica DISLike 2", "¿Qué quereis desayunar?"),
            Cookie("Tosta Rica DISLike 3", "¿Qué quereis desayunar?"),
            Cookie("Tosta Rica DISLike 4", "¿Qué quereis desayunar?"),
            Cookie("Oreo", "Interesada en el cine de acción"),
            Cookie("Maria Dorada", "Le gusta tomar el sol y pasear por la playa")
        )

        return listOf.filter(predicate)
    }

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

    companion object RepositoryCompanion {
        private val cookieRepository = CookieRepository()
        fun getInstance(): CookieRepository {
            return cookieRepository
        }

    }
}
