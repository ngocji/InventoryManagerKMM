package com.memest.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.memest.core.currentTimeInMilliseconds
import com.memest.data.database.util.IdUtils

@Entity(
    tableName = "shop",
    foreignKeys = [
        ForeignKey(
            entity = WarehouseEntity::class,
            parentColumns = ["id"],
            childColumns = ["warehouse_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ShopEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String = IdUtils.newShopId,
    @ColumnInfo(name = "warehouse_id")
    val warehouseId: String = IdUtils.defaultWarehouseId,
    @ColumnInfo(name = "name")
    val name: String = "Product blank",
    @ColumnInfo(name = "address")
    val address: String? = null,
    @ColumnInfo(name = "description")
    val description: String? = null,
    @ColumnInfo(name = "email")
    val email: String? = null,
    @ColumnInfo(name = "phone_number")
    val phoneNumber: String? = null,
    @ColumnInfo(name = "images")
    val images: List<String> = emptyList(),
    @ColumnInfo(name = "created_timestamp")
    val createdTimestamp: Long = currentTimeInMilliseconds(),
    @ColumnInfo(name = "updated_timestamp")
    val updatedTimestamp: Long = currentTimeInMilliseconds()
)