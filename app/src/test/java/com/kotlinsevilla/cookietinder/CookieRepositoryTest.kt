package com.kotlinsevilla.cookietinder

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class CookieRepositoryTest {
    private val testCookies = listOf(
        Cookie("Test cookie 1", "Test description for cookie 1"),
        Cookie("Test cookie 2", "Test description for cookie 2"),
        Cookie("Test cookie 3", "Test description for cookie 3"),
        Cookie("Test cookie 4", "Test description for cookie 4"),
        Cookie("Test chocolate cookie 5", "Test description for cookie 5 with chocolate", true)
    )

    private val cookieRepository = CookieRepository(testCookies)

    @Test
    fun `contains a list of cookies`() {
        assertEquals(testCookies.size, cookieRepository.getAllCookies().size)
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


    fun `contains a list of chocolate free cookies`() {

    }
}
