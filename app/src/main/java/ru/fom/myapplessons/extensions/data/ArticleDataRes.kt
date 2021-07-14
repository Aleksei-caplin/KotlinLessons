package ru.fom.myapplessons.extensions.data

import ru.fom.myapplessons.data.local.entities.Article
import ru.fom.myapplessons.data.local.entities.Author
import ru.fom.myapplessons.data.remote.res.ArticleDataRes
import ru.fom.myapplessons.data.remote.res.AuthorRes
import java.util.*

fun ArticleDataRes.toArticle(): Article = Article(
    id = id,
    title = title,
    description = description,
    author = author.toAuthor(),
    categoryId = category.id,
    poster = poster,
    date = date,
    updatedAt = Date()
)

fun AuthorRes.toAuthor(): Author = Author(
    userid = id,
    avatar = avatar,
    name = name
)