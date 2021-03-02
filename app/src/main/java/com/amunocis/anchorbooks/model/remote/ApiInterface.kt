package com.amunocis.anchorbooks.model.remote

import com.amunocis.anchorbooks.model.local.entities.Book
import com.amunocis.anchorbooks.model.remote.pojo.BookWrapper
import com.amunocis.anchorbooks.model.remote.pojo.DetailWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("books")
    suspend fun fetchBookList(): Response<List<BookWrapper>>

    @GET("bookDetail/{id}")
    suspend fun fetchDetailList(@Path("id")id: Int): Response<DetailWrapper>
}