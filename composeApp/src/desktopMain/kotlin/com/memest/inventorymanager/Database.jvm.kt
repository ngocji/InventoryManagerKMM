package com.memest.inventorymanager

import androidx.room.Room
import androidx.room.RoomDatabase
import com.memest.inventorymanager.data.database.AppDatabase
import com.memest.inventorymanager.data.database.dbFileName
import java.io.File

fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
    val dbFile = File(System.getProperty("java.io.tmpdir"), dbFileName)
    return Room.databaseBuilder<AppDatabase>(
        name = dbFile.absolutePath,
    )
}