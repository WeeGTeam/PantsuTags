package moe.mizugi.pantsutags.imageloader

import coil3.ImageLoader
import coil3.PlatformContext
import coil3.request.CachePolicy
import coil3.request.crossfade
import coil3.util.DebugLogger
import io.github.vinceglb.filekit.coil.addPlatformFileSupport

fun imageLoaderFactory(context: PlatformContext): ImageLoader =
    ImageLoader.Builder(context)
        .components { addPlatformFileSupport() }
        .crossfade(true)
        .networkCachePolicy(CachePolicy.ENABLED)
        .applyPlatformCache(context)
        .logger(DebugLogger())
        .build()

expect fun ImageLoader.Builder.applyPlatformCache(context: PlatformContext): ImageLoader.Builder