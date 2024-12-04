package com.memest.datastore

import android.content.Context
import org.koin.core.scope.Scope

actual fun getDataStorePath(scope: Scope): String {
    val context = scope.get<Context>()
    return context.filesDir.absolutePath
}

