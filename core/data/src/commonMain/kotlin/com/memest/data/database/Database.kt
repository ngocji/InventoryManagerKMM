package com.memest.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.SQLiteDriver
import com.memest.data.database.convertes.ListStringConvert
import com.memest.data.database.dao.CategoryDao
import com.memest.data.database.entity.CategoryEntity
import com.memest.data.database.entity.DiscountEntity
import com.memest.data.database.entity.InventoryEntity
import com.memest.data.database.entity.ProductEntity
import com.memest.data.database.entity.SaleTransactionEntity
import com.memest.data.database.entity.ShopEntity
import com.memest.data.database.entity.ShopProductPriceEntity
import com.memest.data.database.entity.Statistic
import com.memest.data.database.entity.TransactionEntity
import com.memest.data.database.entity.WarehouseEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(
    entities = [CategoryEntity::class, DiscountEntity::class, InventoryEntity::class, ProductEntity::class, SaleTransactionEntity::class, ShopEntity::class, ShopProductPriceEntity::class, TransactionEntity::class, WarehouseEntity::class, Statistic::class],
    version = 1,
    exportSchema = true,
    autoMigrations = []
)
@TypeConverters(ListStringConvert::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao

    companion object {
        fun createDatabase(builder: Builder<AppDatabase>): AppDatabase {
            return builder
                .fallbackToDestructiveMigration(dropAllTables = true)
                .setQueryCoroutineContext(Dispatchers.IO)
                .build()
        }
    }
}

internal const val dbFileName = "inventory_manager.db"