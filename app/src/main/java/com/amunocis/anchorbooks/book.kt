package com.amunocis.anchorbooks

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_table")
data class book(@PrimaryKey val id: Int)