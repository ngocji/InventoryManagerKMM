package com.memest.inventorymanager.di

import com.memest.data.di.dataModule
import org.koin.core.module.Module

expect val contextModule: Module

val appModules = listOf(contextModule, dataModule)