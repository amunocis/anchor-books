package com.amunocis.anchorbooks.model.remote.pojo

import com.google.gson.annotations.SerializedName

data class DetailWrapper(
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
    @SerializedName("link")
    val link: String,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("year")
    val year: Int,
    @SerializedName("price")
    val price: Int,
    @SerializedName("lastPrice")
    val lastPrice: Int,
    @SerializedName("delivery")
    val delivery: Boolean
)
