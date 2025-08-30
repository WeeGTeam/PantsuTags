package moe.mizugi.pantsutags

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform