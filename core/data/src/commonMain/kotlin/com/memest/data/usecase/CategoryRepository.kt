package com.memest.data.usecase

import com.memest.data.database.AppDatabase
import com.memest.data.database.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class CategoryRepository(private val appDatabase: AppDatabase) {
    fun getCategories(): Flow<List<CategoryEntity>> {
        return appDatabase.categoryDao().getCategories()
    }
}