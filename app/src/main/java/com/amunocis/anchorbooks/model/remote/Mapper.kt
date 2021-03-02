package com.amunocis.anchorbooks.model.remote

import com.amunocis.anchorbooks.model.local.entities.Book
import com.amunocis.anchorbooks.model.local.entities.Detail
import com.amunocis.anchorbooks.model.remote.pojo.BookWrapper
import com.amunocis.anchorbooks.model.remote.pojo.DetailWrapper

fun fromInternetToBookEntity(list: List<BookWrapper>): List<Book> {
    val bookList = mutableListOf<Book>()
    list.map {
        bookList.add(Book(
            it.id,
            it.author,
            it.country,
            it.imageLink,
            it.language,
            it.title))
    }
    return bookList
}

fun fromInternetToDetailEntity(book: DetailWrapper, id: Int): Detail {
    return Detail(
            book.id,
            book.author,
            book.country,
            book.imageLink,
            book.language,
            book.link,
            book.pages,
            book.title,
            book.year,
            book.price,
            book.lastPrice,
            book.delivery)
}
