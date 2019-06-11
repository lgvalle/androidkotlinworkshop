package com.kotlinsevilla.cookietinder


class CookieRepository {

    fun getAllCookies() = listOf(
        Cookie("Tosta Rica", "¿Qué quereis desayunar?"),
        Cookie("Oreo", "Interesada en el cine de acción"),
        Cookie("Maria Dorada", "Le gusta tomar el sol y pasear por la playa")
    )
}
