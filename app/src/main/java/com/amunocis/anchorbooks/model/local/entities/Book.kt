package com.amunocis.anchorbooks.model.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_table")
data class Book(
    @PrimaryKey
    val id: Int,
    val author: String,
    val country: String,
    val imageLink: String,
    val language: String,
    val title: String
)