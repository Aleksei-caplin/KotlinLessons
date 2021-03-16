package ru.fom.myapplessons.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "civilization")
data class Civilization(
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String,
    @Embedded(prefix = "author")
    val author: Author,
    @ColumnInfo(name = "category_id")
    val categoryId: String,
    val poster: String,
    val date: Date,
    @ColumnInfo(name = "updated_at")
    val updatedAt: Date
)

data class Author(
    val userId: String,
    val avatar: String? = null,
    val name: String
)
