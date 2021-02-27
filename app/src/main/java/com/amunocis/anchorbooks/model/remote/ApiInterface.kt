package com.amunocis.anchorbooks.model.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("books")
    suspend fun fetchBookList(): Response<BookWrapper>

    @GET("bookDetail/{id}")
    suspend fun fetchDetailList(@Path("id")id: Int)
}