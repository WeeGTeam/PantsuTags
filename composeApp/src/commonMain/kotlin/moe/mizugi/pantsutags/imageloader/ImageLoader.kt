package moe.mizugi.pantsutags.imageloader

import coil3.ImageLoader
import coil3.PlatformContext
import coil3.decode.DataSource
import coil3.decode.ImageSource
import coil3.fetch.FetchResult
import coil3.fetch.Fetcher
import coil3.fetch.SourceFetchResult
import coil3.key.Keyer
import coil3.request.CachePolicy
import coil3.request.Options
import coil3.request.crossfade
import coil3.util.DebugLogger
import io.github.vinceglb.filekit.coil.addPlatformFileSupport
import moe.mizugi.pantsutags.api.repository.PantsuServerRepository
import okio.Buffer

fun imageLoaderFactory(context: PlatformContext): ImageLoader =
    ImageLoader.Builder(context)
        .components {
            addPlatformFileSupport()
            add(PantsuImageKeyer)
            add(PantsuImageFetcherFactory(
                pantsuServerRepository = PantsuServerRepository("http://localhost:8000")
            ))
        }
        .crossfade(true)
        .networkCachePolicy(CachePolicy.ENABLED)
        .applyPlatformCache(context)
        .logger(DebugLogger())
        .build()

expect fun ImageLoader.Builder.applyPlatformCache(context: PlatformContext): ImageLoader.Builder


data class PantsuImageId(val id: String)

class PantsuImageFetcher(
    private val imageId: PantsuImageId,
    private val options: Options,
    private val imageLoader: ImageLoader,
    private val pantsuServerRepository: PantsuServerRepository,
): Fetcher {
    override suspend fun fetch(): FetchResult? {
        val image = pantsuServerRepository.getImage(imageId.id).getOrNull();
        val buffer = Buffer()
        buffer.write(image!!.data);
        return SourceFetchResult(
            ImageSource(
                source = buffer,
                fileSystem = options.fileSystem,
            ),
            null,
            DataSource.NETWORK
        )
    }
}

class PantsuImageFetcherFactory(
    private val pantsuServerRepository: PantsuServerRepository,
): Fetcher.Factory<PantsuImageId> {
    override fun create(
        data: PantsuImageId,
        options: Options,
        imageLoader: ImageLoader,
    ): PantsuImageFetcher {
        return PantsuImageFetcher(
            data,
            options,
            imageLoader,
            pantsuServerRepository,
        )
    }
}

object PantsuImageKeyer : Keyer<PantsuImageId> {
    override fun key(data: PantsuImageId, options: Options): String {
        return data.id
    }
}