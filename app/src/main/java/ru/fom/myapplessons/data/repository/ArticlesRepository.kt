package ru.fom.myapplessons.data.repository

import androidx.lifecycle.LiveData
import ru.fom.myapplessons.data.local.DbManager.db
import ru.fom.myapplessons.data.remote.NetworkManager
import ru.fom.myapplessons.data.remote.res.ArticleRes
import javax.sql.DataSource


interface IArticlesRepository {
    suspend fun loadArticlesFromNetwork(start: String? = null, size: Int = 10): Int
    suspend fun insertArticlesToDb(articles: List<ArticleRes>)
    suspend fun toggleBookmark(articleId: String): Boolean
    //fun findTags(): LiveData<List<String>>
    //fun findCategoriesData(): LiveData<List<CategoryData>>
    //fun rawQueryArticles(filter: ArticleFilter): DataSource.Factory<Int, ArticleItem>
    suspend fun findLastArticleId(): String?
    suspend fun incrementTagUseCount(tag: String)
    suspend fun fetchArticleContent(articleId: String)
    suspend fun removeArticleContent(articleId: String)
}

object ArticlesRepository : IArticlesRepository {

    private val network = NetworkManager.api
    private var articlesDao = db.articlesDao()

    override suspend fun loadArticlesFromNetwork(start: String?, size: Int): Int {
        val items = network.articles(start, size)
        if (items.isNotEmpty()) insertArticlesToDb(items)
        return items.size
    }

    override suspend fun insertArticlesToDb(articles: List<ArticleRes>) {
        articlesDao.upsert(articles.map { it.data.toA })
    }

    override suspend fun toggleBookmark(articleId: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun findLastArticleId(): String? {
        TODO("Not yet implemented")
    }

    override suspend fun incrementTagUseCount(tag: String) {
        TODO("Not yet implemented")
    }

    override suspend fun fetchArticleContent(articleId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun removeArticleContent(articleId: String) {
        TODO("Not yet implemented")
    }
    //private var articlesDao = db.articlesDao()
    //private var articlesCountsDao = db.articleCountsDao()
    //private var articlesContentDao = db.articleContentsDao()
    //private var categoriesDao = db.categoriesDao()
    //private var tagsDao = db.tagsDao()
    //private var articlesPersonalDao = db.articlePersonalInfosDao()

}