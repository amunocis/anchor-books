package com.amunocis.anchorbooks.model.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.amunocis.anchorbooks.model.local.entities.Book


@Dao
interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllBookList(listBook: List<Book>)

    @Query("SELECT * FROM book_table ORDER BY id ASC")
    fun getAllBookList(): LiveData<List<Book>>

    @Query("SELECT * FROM book_table WHERE id = :id")
    fun getBookById(id: Int): LiveData<Book>
}