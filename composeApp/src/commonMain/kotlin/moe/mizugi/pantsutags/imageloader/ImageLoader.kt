package moe.mizugi.pantsutags.imageloader

import coil3.ImageLoader
import coil3.PlatformContext
import coil3.disk.DiskCache
import coil3.memory.MemoryCache
import coil3.request.CachePolicy
import coil3.request.crossfade
import coil3.util.DebugLogger
import io.github.vinceglb.filekit.coil.addPlatformFileSupport
import me.sujanpoudel.utils.paths.appCacheDirectory
import okio.Path.Companion.toPath

fun imageLoaderFactory(context: PlatformContext): ImageLoader =
    ImageLoader.Builder(context)
        .components { addPlatformFileSupport() }
        .crossfade(true)
        .memoryCachePolicy(CachePolicy.ENABLED)
        .diskCachePolicy(CachePolicy.ENABLED)
        .networkCachePolicy(CachePolicy.ENABLED)
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
        .logger(DebugLogger())
        .build()