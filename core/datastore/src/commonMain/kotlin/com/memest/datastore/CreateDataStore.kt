@file:OptIn(InternalCoroutinesApi::class)

package com.memest.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.SynchronizedObject
import kotlinx.coroutines.internal.synchronized
import okio.Path.Companion.toPath


expect fun getDataStorePath(): String

fun createDataStore(): DataStore<Preferences> =
    PreferenceDataStoreFactory.createWithPath(
        produceFile = { getDataStorePath().toPath().resolve(dataStoreFileName) }
    )

internal const val dataStoreFileName = "app.preferences_pb"


private lateinit var dataStore: DataStore<Preferences>
private val lock = SynchronizedObject()

fun getDataStore(): DataStore<Preferences> {
    synchronized(lock) {
        if (!::dataStore.isInitialized) {
            dataStore = createDataStore()
        }
        return dataStore
    }
}