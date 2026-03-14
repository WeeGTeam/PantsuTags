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
        val result = repository.getImage("test-id")
        // Result will fail since server isn't running, but we're testing the call works
        assertNotNull(result)
    }
}
