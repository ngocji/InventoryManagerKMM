package com.memest.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.memest.core.currentTimeInMilliseconds
import com.memest.data.database.util.IdUtils

@Entity(
    tableName = "sale_transactions",
    foreignKeys = [
        ForeignKey(
            entity = WarehouseEntity::class,
            parentColumns = ["id"],
            childColumns = ["warehouse_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ShopEntity::class,
            parentColumns = ["id"],
            childColumns = ["shop_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ProductEntity::class,
            parentColumns = ["id"],
            childColumns = ["product_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class SaleTransactionEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String = IdUtils.newSaleTransactionId,
    @ColumnInfo(name = "warehouse_id")
    val warehouseId: String = IdUtils.defaultWarehouseId,
    @ColumnInfo(name = "product_id")
    val productId: String,
    @ColumnInfo(name = "shop_id")
    val shopId: String,
    @ColumnInfo(name = "quantity")
    val quantity: Int = 0,
    @ColumnInfo(name = "price")
    val price: Double = 0.0,
    @ColumnInfo(name = "timestamp")
    val timestamp: Long = currentTimeInMilliseconds()
)