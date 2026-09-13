package moe.mizugi.pantsutags.api.repository

import io.ktor.client.*
import moe.mizugi.pantsutags.api.generated.api.ImageApi

class ImageRepository(
    private val baseUrl: String,
    private val httpClient: HttpClient,
) {
    private val imageApi = ImageApi(baseUrl = baseUrl, httpClient = httpClient)

    suspend fun getImages(): Result<List<String>> {
        return try {
            val imageIds = imageApi.getImages().body()
            Result.success(imageIds)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
