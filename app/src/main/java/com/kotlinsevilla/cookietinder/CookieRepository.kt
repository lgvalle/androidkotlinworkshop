package com.kotlinsevilla.cookietinder


class CookieRepository(dataSet: List<Cookie> = emptyList()) {

    private val liked = mutableListOf<Cookie>()
    private val disliked = mutableListOf<Cookie>()
    private val allCookies = dataSet.takeIf { it.isNotEmpty() } ?: listOf(
        Cookie("Tosta Rica", "¿Qué quereis desayunar?"),
        Cookie("Oreo", "Interesada en el cine de acción", true),
        Cookie("Tosta Rica Like 1", "¿Qué quereis desayunar?"),
        Cookie("Tosta Rica Like 2", "¿Qué quereis desayunar?"),
        Cookie("Tosta Rica Like 3", "¿Qué quereis desayunar?"),
        Cookie("Tosta Rica Like 4", "¿Qué quereis desayunar?"),
        Cookie("Tosta Rica DISLike 1", "¿Qué quereis desayunar?"),
        Cookie("Tosta Rica DISLike 2", "¿Qué quereis desayunar?"),
        Cookie("Tosta Rica DISLike 3", "¿Qué quereis desayunar?"),
        Cookie("Tosta Rica DISLike 4", "¿Qué quereis desayunar?"),
        Cookie("Maria Dorada", "Le gusta tomar el sol y pasear por la playa")
    )

    fun getAllCookies(predicate: (Cookie) -> Boolean = { true }) = allCookies.filter(predicate)

    fun getChocolateFreeCookies() = allCookies.filter { !it.hasChocolate }

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
