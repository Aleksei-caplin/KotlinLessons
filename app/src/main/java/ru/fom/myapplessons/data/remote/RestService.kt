package ru.fom.myapplessons.data.remote

import retrofit2.http.GET
import retrofit2.http.Query
import ru.fom.myapplessons.data.remote.res.ArticleRes

interface RestService {

    @GET("articles")
    suspend fun articles(
        @Query("last") last: String?=null,
        @Query("limit") limit: Int = 10
    ): List<ArticleRes>
}