package com.memest.inventorymanager.utils

import kotlinx.datetime.Clock

object DateUtils {
    fun currentTimeInMills(): Long {
        return Clock.System.now().toEpochMilliseconds()
    }
}