package moe.mizugi.pantsutags.presentation

import moe.mizugi.pantsutags.presentation.gallery.GalleryViewModel
import moe.mizugi.pantsutags.presentation.image.ImageViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::GalleryViewModel)
    viewModelOf(::ImageViewModel)
}
