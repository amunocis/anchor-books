package com.amunocis.anchorbooks.model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object {
        private const val BASE_URL = "https://my-json-server.typicode.com/Himuravidal/anchorBooks/"

        fun retrofitInstance(): ApiInterface {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}