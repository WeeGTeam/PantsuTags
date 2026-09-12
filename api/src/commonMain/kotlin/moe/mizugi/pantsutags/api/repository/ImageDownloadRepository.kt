package moe.mizugi.pantsutags.api.repository

import io.ktor.client.*
import moe.mizugi.pantsutags.api.generated.api.ImageDownloadApi
import moe.mizugi.pantsutags.api.model.Image

class ImageDownloadRepository(
    private val baseUrl: String,
    private val httpClient: HttpClient,
) {
    private val imageDownloadApi = ImageDownloadApi(baseUrl = baseUrl, httpClient = httpClient)

    suspend fun getImage(id: String): Result<Image> {
        return try {
            // Use Ktor directly for binary responses - generated API expects JSON serialization
            val bytes = imageDownloadApi.getImage(id)
            Result.success(Image(id = id, data = bytes.body()))

        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
