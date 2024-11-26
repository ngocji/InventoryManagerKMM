package com.memest.inventorymanager.data.database.entity

import androidx.annotation.StringDef
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.memest.inventorymanager.data.database.util.IdUtils
import com.memest.inventorymanager.utils.DateUtils

const val TYPE_STATISTIC_SHOP = "TYPE_STATISTIC_SHOP"
const val TYPE_STATISTIC_CATEGORY = "TYPE_STATISTIC_CATEGORY"
const val TYPE_STATISTIC_PRODUCT = "TYPE_STATISTIC_PRODUCT"
const val TYPE_STATISTIC_WAREHOUSE = "TYPE_STATISTIC_WAREHOUSE"


@StringDef(
    TYPE_STATISTIC_SHOP,
    TYPE_STATISTIC_CATEGORY,
    TYPE_STATISTIC_PRODUCT,
    TYPE_STATISTIC_WAREHOUSE
)
@Retention(AnnotationRetention.SOURCE)
annotation class StatisticType

@Entity(tableName = "statistic",)
data class Statistic(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String = IdUtils.newStatisticId,
    @ColumnInfo(name = "type")
    @StatisticType
    val type: String,
    @ColumnInfo(name = "target_id")
    val targetId: String,
    @ColumnInfo(name = "period")
    val period: String, // in day
    @ColumnInfo(name = "total_revenue")
    val totalRevenue: Float,
    @ColumnInfo(name = "total_quantity")
    val totalQuantity: Int,
    @ColumnInfo(name = "created_timestamp")
    val createdTimestamp: Long = DateUtils.currentTimeInMills(),
    @ColumnInfo(name = "updated_timestamp")
    val updatedTimestamp: Long = DateUtils.currentTimeInMills()
)