package moe.mizugi.pantsutags.api.repository

import io.ktor.client.*
import io.ktor.client.request.forms.*
import io.ktor.http.*
import io.ktor.utils.io.core.*
import moe.mizugi.pantsutags.api.generated.api.ImageImportApi

class ImageImportRepository(
    private val baseUrl: String,
    private val httpClient: HttpClient,
) {
    private val imageImportApi = ImageImportApi(baseUrl = baseUrl, httpClient = httpClient)

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
}
