package com.amunocis.anchorbooks.model.remote

import com.google.gson.annotations.SerializedName

data class BookWrapper(
    @SerializedName("id")
    val id: Int,
    @SerializedName("author")
    val author: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("imageLink")
    val imageLink: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("title")
    val title: String
)
