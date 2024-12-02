package com.memest.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.memest.core.currentTimeInMilliseconds
import com.memest.data.database.util.IdUtils

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
    val createdTimestamp: Long = currentTimeInMilliseconds(),
    @ColumnInfo(name = "updated_timestamp")
    val updatedTimestamp: Long = currentTimeInMilliseconds()
)