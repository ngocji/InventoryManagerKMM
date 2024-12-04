package com.memest.datastore.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.memest.datastore.createDataStore
import org.koin.dsl.module

val dataStoreModule = module {
    single<DataStore<Preferences>> {
        createDataStore(this)
    }
}