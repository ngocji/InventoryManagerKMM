package com.memest.core
import platform.Foundation.NSLog

actual fun log(tag: String, message: String) {
    NSLog("$tag: $message")
}

actual fun logError(tag: String, throwable: Throwable?) {
    NSLog("$tag: ${throwable?.message?.let { "\nThrowable: $it" } ?: ""}")
}