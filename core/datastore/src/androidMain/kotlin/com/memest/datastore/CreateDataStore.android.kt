package com.memest.datastore

import android.content.Context
import org.koin.java.KoinJavaComponent.getKoin

actual fun getDataStorePath(): String {
    val context = getKoin().get<Context>()
    return context.filesDir.absolutePath
}

