package com.memest.datastore

import org.koin.core.scope.Scope


actual fun getDataStorePath(scope: Scope): String {
    return System.getProperty("java.io.tmpdir")
}

