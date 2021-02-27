package com.amunocis.anchorbooks.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_table")
data class Book(@PrimaryKey val id: Int)