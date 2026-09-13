package moe.mizugi.pantsutags.api.repository

import io.ktor.client.*
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertNotNull

class ImageRepositoryTest {

    @Test
    fun testRepositoryCreation() = runTest {
        val repository = ImageRepository("http://localhost:8000", HttpClient())
        assertNotNull(repository)
    }
}
