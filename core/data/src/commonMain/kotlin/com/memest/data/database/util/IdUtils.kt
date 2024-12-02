package com.memest.data.database.util

object IdUtils {
    private fun generateRandomString(length: Int): String {
        val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        return (1..length)
            .map { chars.random() }
            .joinToString("")
    }

    val defaultWarehouseId get() = "warehouse_default"
    val newWarehouseId get() = "warehouse_${generateRandomString(10)}"
    val newProductId get() = "product_${generateRandomString(10)}"
    val newCategoryId get() = "category_${generateRandomString(10)}"
    val newShopId get() = "shop_${generateRandomString(10)}"
    val newDiscountId get() = "discount_${generateRandomString(10)}"
    val newInventoryId get() = "inventory_${generateRandomString(10)}"
    val newTransactionId get() = "transaction_${generateRandomString(10)}"
    val newSaleTransactionId get() = "sale_transaction_${generateRandomString(10)}"
    val newStatisticId get() = "statistic_${generateRandomString(10)}"

}