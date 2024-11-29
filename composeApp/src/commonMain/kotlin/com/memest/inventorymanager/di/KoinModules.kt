package com.memest.inventorymanager.di

import org.koin.core.module.Module

expect val contextModule: Module

val appModules = listOf(contextModule)