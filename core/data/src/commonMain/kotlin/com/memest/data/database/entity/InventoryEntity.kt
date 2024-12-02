package com.memest.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.memest.core.currentTimeInMilliseconds
import com.memest.data.database.util.IdUtils

@Entity(
    tableName = "inventories",
    foreignKeys = [
        ForeignKey(
            entity = WarehouseEntity::class,
            parentColumns = ["id"],
            childColumns = ["warehouse_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class InventoryEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String = IdUtils.newInventoryId,
    @ColumnInfo(name = "warehouse_id")
    val warehouseId: String = IdUtils.defaultWarehouseId,
    @ColumnInfo(name = "product_id")
    val productId: String,
    @ColumnInfo(name = "shop_id")
    val shopId: String? = null,
    @ColumnInfo(name = "quantity")
    val quantity: Int = 0,
    @ColumnInfo(name = "created_timestamp")
    val createdTimestamp: Long = currentTimeInMilliseconds(),
    @ColumnInfo(name = "updated_timestamp")
    val updatedTimestamp: Long = currentTimeInMilliseconds()
)