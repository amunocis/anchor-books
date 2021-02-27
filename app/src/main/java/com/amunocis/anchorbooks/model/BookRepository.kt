package com.amunocis.anchorbooks.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.amunocis.anchorbooks.model.local.dao.BookDao
import com.amunocis.anchorbooks.model.local.dao.DetailDao
import com.amunocis.anchorbooks.model.local.entities.Book
import com.amunocis.anchorbooks.model.remote.pojo.BookWrapper
import com.amunocis.anchorbooks.model.remote.RetrofitInstance
import com.amunocis.anchorbooks.model.remote.fromInternetToBookEntity
import com.amunocis.anchorbooks.model.remote.fromInternetToDetailEntity

class BookRepository(private val bookDao: BookDao, private val detailDao: DetailDao) {
    private val networkService = RetrofitInstance.retrofitInstance()
    val dataFromInternet = MutableLiveData<List<BookWrapper>>()
    val bookListLiveData: LiveData<List<Book>> = bookDao.getAllBookList()

    suspend fun fetchBooksData() {
        val service = kotlin.runCatching { networkService.fetchBookList() }
        service.onSuccess {
            when(it.code()) {
                200 -> it.body()?.let {
                    bookDao.insertAllBookList(fromInternetToBookEntity(it))
                }
                else -> Log.d("REPO", "${it.errorBody()}")
            }
        }
        service.onFailure {
            Log.e("REPO", "${it.message}")
        }
    }

    suspend fun fetchBookDetail(id: Int) {
        val service =kotlin.runCatching { networkService.fetchDetailList(id) }
        service.onSuccess {
            when(it.code()) {
                200 -> it.body()?.let {
                    detailDao.insertAllDetailList(fromInternetToDetailEntity(it))
                }
            }
        }
    }

    fun getBookById(id: Int): LiveData<Book> {
        return bookDao.getBookById(id)
    }
}