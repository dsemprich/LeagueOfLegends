package utils

import java.io.InputStreamReader

class MockResponseFileReader(path: String) {
    val content: String
    init {
        val reader = InputStreamReader(this::class.java.getResourceAsStream(path))
        content = reader.readText()
        reader.close()
    }
}