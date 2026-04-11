package moe.mizugi.pantsutags.api.model

data class ImageImportRequest(
    val imageFile: ByteArray,
    val imageId: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as ImageImportRequest

        if (!imageFile.contentEquals(other.imageFile)) return false
        if (imageId != other.imageId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = imageFile.contentHashCode()
        result = 31 * result + imageId.hashCode()
        return result
    }
}
