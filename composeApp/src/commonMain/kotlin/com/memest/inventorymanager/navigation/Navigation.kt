package com.memest.inventorymanager.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.memest.data.database.AppDatabase
import com.memest.data.usecase.CategoryRepository
import org.koin.compose.koinInject

@Composable
fun AppNavigation() {
    val repository = koinInject<CategoryRepository>()
    LaunchedEffect(Unit) {
        repository.getCategories().collect {
            println(it)
        }
    }
}