package com.memest.inventorymanager

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "InventoryManager",
    ) {
        App()
    }
}