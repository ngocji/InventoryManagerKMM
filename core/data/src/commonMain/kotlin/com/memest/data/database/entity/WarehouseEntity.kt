package com.memest.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.memest.core.currentTimeInMilliseconds
import com.memest.data.database.util.IdUtils

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
    val createdTimestamp: Long = currentTimeInMilliseconds(),
    @ColumnInfo(name = "updated_timestamp")
    val updatedTimestamp: Long = currentTimeInMilliseconds()
)