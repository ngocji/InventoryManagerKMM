package com.memest.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import org.koin.core.scope.Scope

actual class DatabaseFactory actual constructor() {
    actual fun createDatabaseBuilder(scope: Scope): RoomDatabase.Builder<AppDatabase> {
        val appContext = scope.get<Context>()
        val dbFile = appContext.getDatabasePath(dbFileName)
        return Room.databaseBuilder<AppDatabase>(
            context = appContext,
            name = dbFile.absolutePath
        )
    }
}