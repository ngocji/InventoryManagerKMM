package com.memest.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.memest.core.currentTimeInMilliseconds
import com.memest.data.database.util.IdUtils

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
    val createdTimestamp: Long = currentTimeInMilliseconds(),
    @ColumnInfo(name = "updated_timestamp")
    val updatedTimestamp: Long = currentTimeInMilliseconds()
)