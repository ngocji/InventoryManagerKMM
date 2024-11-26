package com.memest.inventorymanager.data.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import com.memest.inventorymanager.data.database.convertes.ListStringConvert
import com.memest.inventorymanager.data.database.entity.CategoryEntity
import com.memest.inventorymanager.data.database.entity.DiscountEntity
import com.memest.inventorymanager.data.database.entity.InventoryEntity
import com.memest.inventorymanager.data.database.entity.ProductEntity
import com.memest.inventorymanager.data.database.entity.SaleTransactionEntity
import com.memest.inventorymanager.data.database.entity.ShopEntity
import com.memest.inventorymanager.data.database.entity.ShopProductPriceEntity
import com.memest.inventorymanager.data.database.entity.Statistic
import com.memest.inventorymanager.data.database.entity.TransactionEntity
import com.memest.inventorymanager.data.database.entity.WarehouseEntity

@Database(
    entities = [CategoryEntity::class, DiscountEntity::class, InventoryEntity::class, ProductEntity::class, SaleTransactionEntity::class, ShopEntity::class, ShopProductPriceEntity::class, TransactionEntity::class, WarehouseEntity::class, Statistic::class],
    version = 1,
    exportSchema = true,
    autoMigrations = []
)
@TypeConverters(ListStringConvert::class)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase() {

}

// The Room compiler generates the `actual` implementations.
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}

internal const val dbFileName = "inventory_manager.db"