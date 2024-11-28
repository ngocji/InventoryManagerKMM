package com.memest.core

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

inline fun <reified T> T?.encodeToJson(): String {
    this ?: return "{}"
    return try {
        Json.encodeToString(this)
    } catch (e: Exception) {
        "{}"
    }
}

inline fun <reified T> String?.decodeFromJson(default: T?): T? {
    return try {
        Json.decodeFromString<T>(this ?: "{}")
    } catch (e: Exception) {
        default
    }
}