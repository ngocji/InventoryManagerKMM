package com.memest.data.database

import androidx.room.RoomDatabase
import org.koin.core.scope.Scope

expect class DatabaseFactory() {
    fun createDatabaseBuilder(scope: Scope): RoomDatabase.Builder<AppDatabase>
}