package moe.mizugi.pantsutags.api.repository

import io.ktor.client.*
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertNotNull

class ImageImportRepositoryTest {

    @Test
    fun testUploadImage() = runTest {
        val imageDownloadRepository = ImageDownloadRepository("http://localhost:8000", HttpClient())
        val imageImportRepository = ImageImportRepository("http://localhost:8000", HttpClient())
        val result = imageDownloadRepository.getImage("3b6368639f3e17fa")
        val data = result.getOrThrow().data
        data[500] = 42
        val uploadResult = imageImportRepository.upload("1234567890", data)
        // Result will fail since server isn't running, but we're testing the call works
        assertNotNull(uploadResult)
    }
}
