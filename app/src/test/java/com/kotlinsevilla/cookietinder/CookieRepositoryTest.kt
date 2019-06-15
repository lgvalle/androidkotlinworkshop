package com.kotlinsevilla.cookietinder

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class CookieRepositoryTest {
    private val anyImageResourceId = 1234
    private val testCookies = listOf(
        Cookie("a cookie", "Description for a cookie", anyImageResourceId),
        Cookie("Second Cookie", "Description for the second cookie", anyImageResourceId),
        Cookie("Faceless cookie", "Description for a cookie without image"),
        Cookie("another Cookie", "Description for another cookie", anyImageResourceId)
    )
    private val cookieRepository = CookieRepository(testCookies)

    @Test
    fun `contains a list of cookies`() {
        assertEquals(testCookies.size, cookieRepository.getAllCookies().size)
    }

    @Test
    fun `list of cookies contains only cookies with image, sorted by name in camel case`() {
        val expectedListOfCookies = listOf(
            Cookie("A Cookie", "Description for a cookie", 1234),
            Cookie("Another Cookie", "Description for another cookie", 4567),
            Cookie("Second Cookie", "Description for the second cookie", 1234)
        )

        val allTheCookies = cookieRepository.getAllCookies()

        assertEquals(expectedListOfCookies, allTheCookies)
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
