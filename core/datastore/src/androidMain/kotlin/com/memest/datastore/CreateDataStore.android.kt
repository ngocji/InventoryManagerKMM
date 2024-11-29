package com.memest.datastore

import android.content.Context
import org.koin.mp.KoinPlatform.getKoin

actual fun getDataStorePath(): String {
    val context = getKoin().get<Context>()
    return context.filesDir.absolutePath
}

