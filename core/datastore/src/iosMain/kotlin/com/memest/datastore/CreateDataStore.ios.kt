package com.memest.datastore

import org.koin.core.scope.Scope
import platform.Foundation.*

actual fun getDataStorePath(scope: Scope): String {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null,
    )
    return requireNotNull(documentDirectory?.path)
}

