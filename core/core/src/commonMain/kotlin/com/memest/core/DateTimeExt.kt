package com.memest.core

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.datetime.format.byUnicodePattern

fun currentTimeInMilliseconds() = Clock.System.now().toEpochMilliseconds()

@OptIn(FormatStringsInDatetimeFormats::class)
fun String.toLocalDateTime(format: String): LocalDateTime? {
    return try {
        val formatter = LocalDateTime.Format {
            byUnicodePattern(format)
        }

        formatter.parse(this)
    } catch (e: Exception) {
        null
    }
}

@OptIn(FormatStringsInDatetimeFormats::class)
fun LocalDateTime?.format(format: String): String {
    return try {
        val date = this ?: return ""
        val formatter = LocalDateTime.Format {
            byUnicodePattern(format)
        }
        formatter.format(date)
    } catch (e: Exception) {
        ""
    }
}