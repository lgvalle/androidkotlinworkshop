package com.kotlinsevilla.cookietinder

import org.junit.Assert.assertTrue
import org.junit.Test

class CookieRepositoryTest {
    private val cookieRepository = CookieRepository()

    @Test
    fun `contains a list of cookies`() {
        assertTrue(cookieRepository.getAllCookies().isNotEmpty())
    }

    @Test
    fun `initial list of liked cookies is empty`() {
        assertTrue(cookieRepository.likedCookies().isEmpty())
    }

    @Test
    fun `initial list of disliked cookies is empty`() {
        assertTrue(cookieRepository.dislikedCookies().isEmpty())
    }

    @Test
    fun `a cookie can be liked`() {
        val cookie = Cookie("a liked cookie name", "a liked cookie desc")

        cookieRepository.like(cookie)

        assertTrue(cookieRepository.likedCookies().contains(cookie))
    }

    @Test
    fun `a cookie can be disliked`() {
        val cookie = Cookie("a disliked cookie name", "a disliked cookie desc")

        cookieRepository.dislike(cookie)

        assertTrue(cookieRepository.dislikedCookies().contains(cookie))
    }
}
