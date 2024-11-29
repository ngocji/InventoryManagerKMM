package com.memest.inventorymanager.di

import com.memest.inventorymanager.MemeApp
import org.koin.dsl.module

actual val contextModule = module {
    single { MemeApp.context }
}