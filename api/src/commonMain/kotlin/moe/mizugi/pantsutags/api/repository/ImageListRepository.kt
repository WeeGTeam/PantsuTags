package moe.mizugi.pantsutags.api.repository

import io.ktor.client.*
import moe.mizugi.pantsutags.api.generated.api.ImageListApi

class ImageListRepository(
    private val baseUrl: String,
    private val httpClient: HttpClient,
) {
    private val imageListApi = ImageListApi(baseUrl = baseUrl, httpClient = httpClient)

    suspend fun getImages(): Result<List<String>> {
        return try {
            val imageIds = imageListApi.getImages().body()
            Result.success(imageIds)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
