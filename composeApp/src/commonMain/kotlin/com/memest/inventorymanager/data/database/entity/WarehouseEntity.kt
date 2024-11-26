package com.memest.inventorymanager.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.memest.inventorymanager.data.database.util.IdUtils
import com.memest.inventorymanager.utils.DateUtils

@Entity(tableName = "warehouses")
data class WarehouseEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String = IdUtils.newWarehouseId,
    @ColumnInfo(name = "name")
    val name: String = "Warehouse blank",
    @ColumnInfo(name = "description")
    val description: String? = null,
    @ColumnInfo(name = "address")
    val address: String? = null,
    @ColumnInfo(name = "created_timestamp")
    val createdTimestamp: Long = DateUtils.currentTimeInMills(),
    @ColumnInfo(name = "updated_timestamp")
    val updatedTimestamp: Long = DateUtils.currentTimeInMills()
)