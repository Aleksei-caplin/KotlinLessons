package ru.fom.myapplessons.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
class Article(
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String,
    val categoryId: String,
    val poster: String,

) {
}