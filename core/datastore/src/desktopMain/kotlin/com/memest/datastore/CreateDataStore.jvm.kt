package com.memest.datastore


actual fun getDataStorePath(): String {
    return System.getProperty("java.io.tmpdir")
}

