@file:OptIn(InternalCoroutinesApi::class)

package com.memest.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.InternalCoroutinesApi
import okio.Path.Companion.toPath
import org.koin.core.scope.Scope


expect fun getDataStorePath(scope: Scope): String

fun createDataStore(scope: Scope): DataStore<Preferences> =
    PreferenceDataStoreFactory.createWithPath(
        produceFile = { getDataStorePath(scope).toPath().resolve(dataStoreFileName) }
    )

internal const val dataStoreFileName = "app.preferences_pb"