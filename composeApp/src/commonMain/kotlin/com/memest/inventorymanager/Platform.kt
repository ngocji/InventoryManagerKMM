package com.memest.inventorymanager

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform