package com.memest.inventorymanager.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import com.memest.inventorymanager.utils.DateUtils

@Entity(
    tableName = "shop_product_price",
    primaryKeys = ["shop_id", "product_id"],
    foreignKeys = [
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
data class ShopProductPriceEntity(
    @ColumnInfo(name = "shop_id")
    val shopId: String,
    @ColumnInfo(name = "product_id")
    val productId: String,
    @ColumnInfo(name = "price")
    val price: Double = 0.0,
    @ColumnInfo(name = "created_timestamp")
    val createdTimestamp: Long = DateUtils.currentTimeInMills(),
    @ColumnInfo(name = "updated_timestamp")
    val updatedTimestamp: Long = DateUtils.currentTimeInMills()
)