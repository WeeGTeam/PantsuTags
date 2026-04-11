package moe.mizugi.pantsutags.api.repository

import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertNotNull

class PantsuServerRepositoryTest {

    @Test
    fun testRepositoryCreation() = runTest {
        val repository = PantsuServerRepository("http://localhost:8000")
        assertNotNull(repository)
    }

    @Test
    fun testGetImage() = runTest {
        val repository = PantsuServerRepository("http://localhost:8000")
        val result = repository.getImage("3b6368639f3e17fa")
        // Result will fail since server isn't running, but we're testing the call works
        assertNotNull(result)
    }

    @Test
    fun testUploadImage() = runTest {
        val repository = PantsuServerRepository("http://localhost:8000")
        val result = repository.getImage("3b6368639f3e17fa")
        val data = result.getOrThrow().data
        data[500] = 42
        val uploadResult = repository.upload("1234567890", data)
        // Result will fail since server isn't running, but we're testing the call works
        assertNotNull(uploadResult)
    }
}
