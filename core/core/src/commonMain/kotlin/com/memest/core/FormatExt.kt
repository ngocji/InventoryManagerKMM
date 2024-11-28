package com.memest.core

import kotlin.math.pow
import kotlin.math.roundToInt

fun Long.formatMinSecDuration(): String {
    val totalSeconds = (this + 500) / 1000
    val seconds = totalSeconds % 60
    val minutes = totalSeconds / 60 % 60
    return "${minutes.toString().padStart(2, '0')}:${seconds.toString().padStart(2, '0')}"
}

fun Long.formatFullDuration(): String {
    val totalSeconds = (this + 500) / 1000
    val seconds = totalSeconds % 60
    val minutes = totalSeconds / 60 % 60
    val hours = totalSeconds / 3600
    return "${hours.toString().padStart(2, '0')}:${
        minutes.toString().padStart(2, '0')
    }:${seconds.toString().padStart(2, '0')}"
}

fun Long.formatSize() = toDouble().formatSize()

fun Double.format(decimals: Int): String {
    val factor = 10.0.pow(decimals)
    val roundedValue = (this * factor).roundToInt() / factor
    return roundedValue.toString()
}

fun Double.formatSize(): String {
    return try {
        val kilobyte = 1024.0
        val megabyte = kilobyte * 1024
        val gigabyte = megabyte * 1024
        val terabyte = gigabyte * 1024

        when {
            this >= 0 && this < kilobyte -> "$this B"
            this >= kilobyte && this < megabyte -> "${(this / kilobyte).format(2)} KB"
            this >= megabyte && this < gigabyte -> "${(this / megabyte).format(2)} MB"
            this >= gigabyte && this < terabyte -> "${(this / gigabyte).format(2)} GB"
            this >= terabyte -> "${(this / terabyte).format(2)} TB"
            else -> "$this Bytes"
        }
    } catch (e: Exception) {
        ""
    }
}