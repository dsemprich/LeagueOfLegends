package utils

import java.io.InputStreamReader

class MockResponseFileReader(path: String) {
    val content: String
    init {
        val reader = InputStreamReader(javaClass.getResourceAsStream(path))
        content = reader.readText()
        reader.close()
    }
}