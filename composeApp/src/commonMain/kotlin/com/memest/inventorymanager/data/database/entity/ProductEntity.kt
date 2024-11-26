package com.memest.inventorymanager.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.memest.inventorymanager.data.database.util.IdUtils
import com.memest.inventorymanager.utils.DateUtils

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String = IdUtils.newProductId,
    @ColumnInfo(name = "name")
    val name: String = "Product blank",
    @ColumnInfo(name = "description")
    val description: String? = null,
    @ColumnInfo(name = "price")
    val price: Double = 0.0,
    @ColumnInfo(name = "images")
    val images: List<String> = emptyList(),
    @ColumnInfo(name = "categories_id")
    val categoriesId: List<String> = emptyList(),
    @ColumnInfo(name = "created_timestamp")
    val createdTimestamp: Long = DateUtils.currentTimeInMills(),
    @ColumnInfo(name = "updated_timestamp")
    val updatedTimestamp: Long = DateUtils.currentTimeInMills()
)