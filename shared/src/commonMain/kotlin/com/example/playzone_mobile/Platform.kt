package com.example.playzone_mobile

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform