package moe.mizugi.pantsutags.imageloader

import coil3.ImageLoader
import coil3.PlatformContext
import coil3.memory.MemoryCache
import coil3.request.CachePolicy

actual fun ImageLoader.Builder.applyPlatformCache(context: PlatformContext): ImageLoader.Builder {
    return this
        .memoryCachePolicy(CachePolicy.ENABLED)
        .memoryCache {
            MemoryCache.Builder()
                .maxSizePercent(context, 0.0025)
                .build()
        }
}