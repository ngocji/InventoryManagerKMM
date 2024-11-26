package com.memest.inventorymanager.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.memest.inventorymanager.data.database.util.IdUtils
import com.memest.inventorymanager.utils.DateUtils

@Entity(tableName = "categories")
data class CategoryEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String = IdUtils.newCategoryId,
    @ColumnInfo(name = "name")
    val name: String = "Category blank",
    @ColumnInfo(name = "description")
    val description: String? = null,
    @ColumnInfo(name = "hex_color")
    val hexColor: String? = null,
    @ColumnInfo(name = "avatar")
    val avatar: String? = null,
    @ColumnInfo(name = "tags")
    val tags: List<String> = emptyList(),
    @ColumnInfo(name = "created_timestamp")
    val createdTimestamp: Long = DateUtils.currentTimeInMills(),
    @ColumnInfo(name = "updated_timestamp")
    val updatedTimestamp: Long = DateUtils.currentTimeInMills()
)