package com.memest.inventorymanager

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.memest.inventorymanager.di.appModules
import com.memest.inventorymanager.navigation.AppNavigation
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() {
    KoinApplication(application = {
        modules(appModules)
    }) {
        MaterialTheme {
            AppNavigation()
        }
    }
}