package com.memest.data.di

import com.memest.data.database.AppDatabase
import com.memest.data.database.DatabaseFactory
import com.memest.data.usecase.CategoryRepository
import org.koin.dsl.module

val dataModule = module {

    single<AppDatabase> {
        AppDatabase.createDatabase(
            DatabaseFactory()
                .createDatabaseBuilder(this)
        )
    }

    single<CategoryRepository> {
        CategoryRepository(get())
    }
}