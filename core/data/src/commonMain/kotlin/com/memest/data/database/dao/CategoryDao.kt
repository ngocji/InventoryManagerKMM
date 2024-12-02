package com.memest.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.memest.data.database.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {
    @Query("SELECT * FROM categories order by updated_timestamp desc")
    fun getCategories():Flow<List<CategoryEntity>>
}