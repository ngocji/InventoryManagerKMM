package com.memest.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.memest.data.database.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {
    @Query("SELECT * FROM categories order by updated_timestamp desc")
    fun getCategories(): Flow<List<CategoryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserts(vararg category: CategoryEntity)

    @Delete
    suspend fun delete(category: CategoryEntity)

    @Query("DELETE FROM categories where id = :id")
    suspend fun deleteById(id: String)

    @Query("select * from categories where id = :id")
    fun getCategory(id: String): Flow<CategoryEntity?>
}