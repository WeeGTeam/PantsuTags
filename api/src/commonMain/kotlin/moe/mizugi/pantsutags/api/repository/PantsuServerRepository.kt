package moe.mizugi.pantsutags.api.repository

import io.ktor.client.*
import io.ktor.client.request.forms.*
import io.ktor.http.*
import io.ktor.utils.io.core.*
import moe.mizugi.pantsutags.api.generated.api.ImageDownloadApi
import moe.mizugi.pantsutags.api.generated.api.ImageImportApi
import moe.mizugi.pantsutags.api.model.Image

class PantsuServerRepository(
    baseUrl: String = "http://localhost:8000"
) {
    private val httpClient = HttpClient()
    private val baseUrl = baseUrl
    private val imageDownloadApi = ImageDownloadApi(baseUrl = baseUrl, httpClient = httpClient)
    private val imageImportApi = ImageImportApi(baseUrl = baseUrl, httpClient = httpClient)

    suspend fun getImage(id: String): Result<Image> {
        return try {
            // Use Ktor directly for binary responses - generated API expects JSON serialization
            val bytes = imageDownloadApi.getImage(id)
            Result.success(Image(id = id, data = bytes.body()))

        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun upload(importId: String, data: ByteArray): Result<Unit> {
        return try {
            val filePart: FormPart<InputProvider> = FormPart(
                key = "file",
                value = InputProvider(size = data.size.toLong()) {
                    ByteReadPacket(data)
                },
                headers = Headers.build {
                    append(HttpHeaders.ContentDisposition, "filename=\"photo.jpg\"")
                    append(HttpHeaders.ContentType, "image/jpeg")
                }
            )
            imageImportApi.importImage(importId, filePart)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    fun close() {
        httpClient.close()
    }
}
