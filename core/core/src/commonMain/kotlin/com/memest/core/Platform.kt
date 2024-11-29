package com.memest.core

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform