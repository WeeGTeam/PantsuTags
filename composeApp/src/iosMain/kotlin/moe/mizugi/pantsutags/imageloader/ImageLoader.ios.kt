package moe.mizugi.pantsutags.imageloader

import coil3.ImageLoader
import coil3.PlatformContext
import coil3.disk.DiskCache
import coil3.memory.MemoryCache
import coil3.request.CachePolicy
import me.sujanpoudel.utils.paths.appCacheDirectory
import okio.Path.Companion.toPath

actual fun ImageLoader.Builder.applyPlatformCache(context: PlatformContext): ImageLoader.Builder {
    return this
        .memoryCachePolicy(CachePolicy.ENABLED)
        .diskCachePolicy(CachePolicy.ENABLED)
        .memoryCache {
            MemoryCache.Builder()
                .maxSizePercent(context, 0.0025)
                .build()
        }
        .diskCache {
            DiskCache.Builder()
                .directory(appCacheDirectory("moe.mizugi.PantsuTags", true).toString().toPath())
                .maxSizePercent(0.001)
                .build()
        }
}