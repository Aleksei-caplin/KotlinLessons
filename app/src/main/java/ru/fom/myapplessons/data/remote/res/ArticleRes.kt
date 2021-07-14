package ru.fom.myapplessons.data.remote.res

data class ArticleRes(
    val data: ArticleDataRes,
    val counts: ArticleCountsRes,
    val isActive: Boolean
)