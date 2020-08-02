package com.example.leagueoflegends

import com.example.leagueoflegends.extensions.supportedLanguage
import org.junit.Test

import org.junit.Assert.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class LocaleTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun `print german locale`() {
        val locale = Locale.GERMANY.supportedLanguage()
        assertEquals(locale, "de_DE")
    }

    @Test
    fun `print default locale`() {
        val locale = Locale("de_US").supportedLanguage()
        assertEquals(locale, "en_US")
    }
}