@file:Suppress("UNCHECKED_CAST")

package com.memest.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.memest.core.decodeFromJson
import com.memest.core.encodeToJson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import org.koin.mp.KoinPlatform.getKoin

inline fun <reified T : Any> getPrefKey(key: String): PrefKey {
    var isObjectValue = false

    val prefKey = when (T::class) {
        Int::class -> intPreferencesKey(key)
        Long::class -> longPreferencesKey(key)
        Boolean::class -> booleanPreferencesKey(key)
        Double::class -> doublePreferencesKey(key)
        Float::class -> floatPreferencesKey(key)
        String::class -> stringPreferencesKey(key)
        else -> stringPreferencesKey(key).also {
            isObjectValue = true
        }
    }

    return PrefKey(
        key = prefKey,
        isObjectValue = isObjectValue
    )
}

suspend inline fun <reified T : Any> save(key: String, value: T) {
    val dataStore = getKoin().get<DataStore<Preferences>>()
    dataStore.updateData {
        it.toMutablePreferences().apply {
            when (value::class) {
                Int::class -> {
                    set(intPreferencesKey(key), value as Int)
                }

                Long::class -> {
                    set(longPreferencesKey(key), value as Long)
                }

                Double::class -> {
                    set(doublePreferencesKey(key), value as Double)
                }

                Float::class -> {
                    set(floatPreferencesKey(key), value as Float)
                }

                String::class -> {
                    set(stringPreferencesKey(key), value as String)
                }

                Boolean::class -> {
                    set(booleanPreferencesKey(key), value as Boolean)
                }

                else -> {
                    val encode = value.encodeToJson()
                    set(stringPreferencesKey(key), encode)
                }
            }
        }
    }
}

inline fun <reified T : Any> read(key: String, defaultValue: T): Flow<T> {
    val (prefKey, isObjectValue) = getPrefKey<T>(key)
    val dataStore = getKoin().get<DataStore<Preferences>>()
    return dataStore.data.map {
        it[prefKey]?.let { value ->
            if (isObjectValue) {
                (value.toString()).decodeFromJson(defaultValue) ?: defaultValue
            } else {
                value as T
            }
        } ?: defaultValue
    } as? Flow<T> ?: flowOf(defaultValue)
}

inline fun <reified T : Any> readBlocking(key: String, defaultValue: T): T {
    val (prefKey, isObjectValue) = getPrefKey<T>(key)
    val dataStore = getKoin().get<DataStore<Preferences>>()

    val value = runBlocking {
        dataStore.data.map {
            it[prefKey]?.let { value ->
                if (isObjectValue) {
                    (value.toString()).decodeFromJson(defaultValue)
                } else {
                    value as? T
                }
            }
        }.first()
    }

    return value ?: defaultValue
}

suspend inline fun <reified T : Any> remove(key: String) {
    val dataStore = getKoin().get<DataStore<Preferences>>()
    dataStore.updateData { settings ->
        val prefKey = getPrefKey<T>(key).key
        settings.toMutablePreferences().apply {
            remove(prefKey)
        }
    }
}