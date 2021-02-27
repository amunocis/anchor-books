package com.amunocis.anchorbooks.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.amunocis.anchorbooks.model.BookRepository
import com.amunocis.anchorbooks.model.local.BookDatabase
import com.amunocis.anchorbooks.model.local.entities.Book
import kotlinx.coroutines.launch

class ViewModel(application: Application): AndroidViewModel(application) {
    private val repository: BookRepository

    init {
        val db = BookDatabase.getDatabase(application)
        val bookDao = db.bookDao()
        val detailDao = db.detailDao()
        repository = BookRepository(bookDao, detailDao)

        viewModelScope.launch {
            repository.fetchBooksData()
        }
    }

    fun getBookList(): LiveData<List<Book>> = repository.bookListLiveData

    fun getBookById(id: Int): LiveData<Book> {
        return repository.getBookById(id)
    }
}