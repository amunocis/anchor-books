package com.amunocis.anchorbooks.model.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.amunocis.anchorbooks.model.local.entities.Book
import com.amunocis.anchorbooks.model.local.entities.Detail


@Dao
interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllBookList(listBook: List<Book>)

    @Query("SELECT * FROM book_table ORDER BY id ASC")
    fun getAllBookList(): LiveData<List<Book>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookDetail(bookDetail: Detail)

    @Query("SELECT * FROM detail_table WHERE id = :id")
    fun getDetailByBookId(id: Int): LiveData<Detail>
}