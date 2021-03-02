package com.amunocis.anchorbooks.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.amunocis.anchorbooks.model.BookRepository
import com.amunocis.anchorbooks.model.local.BookDatabase
import com.amunocis.anchorbooks.model.local.entities.Book
import com.amunocis.anchorbooks.model.local.entities.Detail
import kotlinx.coroutines.launch

class BookViewModel(application: Application): AndroidViewModel(application) {
    private val repository: BookRepository
    private var bookSelected = 0

    init {
        val db = BookDatabase.getDatabase(application)
        val bookDao = db.bookDao()
        repository = BookRepository(bookDao)

        viewModelScope.launch {
            repository.fetchBooksData()
        }
    }

    fun getBookList(): LiveData<List<Book>> = repository.bookListLiveData



    fun getBookById(id: Int): LiveData<Detail> = repository.getBookById(id)


    fun getDetailsByIdFromInternet(id:Int) = viewModelScope.launch {
        bookSelected = id
        repository.fetchDetailData(id)
    }
}