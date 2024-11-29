package com.memest.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath


expect fun getDataStorePath(): String

fun createDataStore(): DataStore<Preferences> =
    PreferenceDataStoreFactory.createWithPath(
        produceFile = { getDataStorePath().toPath().resolve(dataStoreFileName) }
    )

internal const val dataStoreFileName = "app.preferences_pb"