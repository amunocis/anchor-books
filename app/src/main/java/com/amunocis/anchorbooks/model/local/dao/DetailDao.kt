package com.amunocis.anchorbooks.model.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.amunocis.anchorbooks.model.local.entities.Detail

@Dao
interface DetailDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllDetailList(listDetail: List<Detail>)

    @Query("SELECT * FROM detail_table WHERE id = :id")
    suspend fun getAllDetail(id: Int): LiveData<List<Detail>>
}