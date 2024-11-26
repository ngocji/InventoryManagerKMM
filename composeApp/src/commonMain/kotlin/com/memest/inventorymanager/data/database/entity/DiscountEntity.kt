package com.memest.inventorymanager.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.memest.inventorymanager.data.database.util.IdUtils
import com.memest.inventorymanager.utils.DateUtils

@Entity(
    tableName = "discounts",
    foreignKeys = [
        ForeignKey(
            entity = ShopEntity::class,
            parentColumns = ["id"],
            childColumns = ["shop_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class DiscountEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String = IdUtils.newDiscountId,
    @ColumnInfo(name = "name")
    val name: String = "Discount",
    @ColumnInfo(name = "shop_id")
    val shopId: String,
    @ColumnInfo(name = "description")
    val description: String? = null,
    @ColumnInfo(name = "code")
    val code: String,
    @ColumnInfo(name = "discount_percent")
    val discountPercent: Float,
    @ColumnInfo(name = "start_date")
    val startDate: Long,
    @ColumnInfo(name = "end_date")
    val endDate: Long,
    @ColumnInfo(name = "created_timestamp")
    val createdTimestamp: Long = DateUtils.currentTimeInMills(),
    @ColumnInfo(name = "updated_timestamp")
    val updatedTimestamp: Long = DateUtils.currentTimeInMills()
)