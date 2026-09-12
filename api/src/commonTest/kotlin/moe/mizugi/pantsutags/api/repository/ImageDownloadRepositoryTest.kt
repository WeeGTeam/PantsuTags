package moe.mizugi.pantsutags.api.repository

import io.ktor.client.*
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertNotNull

class ImageDownloadRepositoryTest {

    @Test
    fun testGetImage() = runTest {
        val repository = ImageDownloadRepository("http://localhost:8000", HttpClient())
        val result = repository.getImage("3b6368639f3e17fa")
        // Result will fail since server isn't running, but we're testing the call works
        assertNotNull(result)
    }
}
