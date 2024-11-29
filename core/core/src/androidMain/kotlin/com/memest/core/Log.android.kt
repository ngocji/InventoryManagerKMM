package com.memest.core

import android.util.Log

actual fun log(tag: String, message: String) {
    Log.d(tag, message)
}

actual fun logError(tag: String, throwable: Throwable?) {
    Log.d(tag, "Error")
    throwable?.printStackTrace()
}