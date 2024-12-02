package com.memest.data.database.entity

import androidx.annotation.StringDef
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.memest.core.currentTimeInMilliseconds
import com.memest.data.database.util.IdUtils

const val TYPE_TRANSACTION_TRANSFER_WAREHOUSE_TO_SHOP = "WAREHOUSE_TO_SHOP"
const val TYPE_TRANSACTION_TRANSFER_SHOP_TO_WAREHOUSE = "SHOP_TO_WAREHOUSE"
const val TYPE_TRANSACTION_TRANSFER_SHOP_TO_SHOP = "SHOP_TO_SHOP"
const val TYPE_TRANSACTION_TRANSFER_WAREHOUSE_TO_WAREHOUSE = "WAREHOUSE_TO_WAREHOUSE"

@StringDef(
    TYPE_TRANSACTION_TRANSFER_WAREHOUSE_TO_SHOP,
    TYPE_TRANSACTION_TRANSFER_SHOP_TO_WAREHOUSE,
    TYPE_TRANSACTION_TRANSFER_SHOP_TO_SHOP,
    TYPE_TRANSACTION_TRANSFER_WAREHOUSE_TO_WAREHOUSE
)
@Retention(AnnotationRetention.SOURCE)
annotation class TransactionType

@Entity(
    tableName = "transactions",
    foreignKeys = [
        ForeignKey(
            entity = WarehouseEntity::class,
            parentColumns = ["id"],
            childColumns = ["warehouse_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ShopEntity::class,
            parentColumns = ["id"],
            childColumns = ["shop_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ProductEntity::class,
            parentColumns = ["id"],
            childColumns = ["product_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class TransactionEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String = IdUtils.newTransactionId,
    @ColumnInfo(name = "warehouse_id")
    val warehouseId: String = IdUtils.defaultWarehouseId,
    @ColumnInfo(name = "product_id")
    val productId: String,
    @ColumnInfo(name = "shop_id")
    val shopId: String? = null,
    @ColumnInfo(name = "quantity")
    val quantity: Int = 0,
    @ColumnInfo(name = "type")
    @TransactionType
    val type: String = TYPE_TRANSACTION_TRANSFER_WAREHOUSE_TO_SHOP,
    @ColumnInfo(name = "timestamp")
    val timestamp: Long = currentTimeInMilliseconds()
)