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

fun fromInternetToDetailEntity(list: List<DetailWrapper>): List<Detail> {
    val detailList = mutableListOf<Detail>()
    list.map {
        detailList.add(Detail(
            it.id,
            it.author,
            it.country,
            it.imageLink,
            it.language,
            it.link,
            it.pages,
            it.title,
            it.year,
            it.price,
            it.lastPrice,
            it.delivery))
    }
    return detailList
}