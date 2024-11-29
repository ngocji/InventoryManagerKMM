package com.memest.core

actual fun log(tag: String, message: String) {
    println("$tag: $message")
}

actual fun logError(tag: String, throwable: Throwable?) {
    println(tag)
    throwable?.printStackTrace()
}