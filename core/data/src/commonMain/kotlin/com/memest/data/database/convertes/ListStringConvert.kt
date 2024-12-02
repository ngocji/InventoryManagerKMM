package com.memest.data.database.convertes

import androidx.room.TypeConverter

class ListStringConvert {
    @TypeConverter
    fun from(items: List<String>): String {
        return items.joinToString(separator = ",")
    }

    @TypeConverter
    fun to(items: String): List<String> {
        return if (items.contains(",")) {
            items.split(",")
        } else {
            listOf(items)
        }
    }
}