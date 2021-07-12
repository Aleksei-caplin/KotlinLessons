package ru.fom.myapplessons.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import ru.fom.myapplessons.data.local.entities.Article

@Dao
interface ArticlesDao: BaseDao<Article> {

    fun upsert(list: List<Article>) {
        insert(list)
            .mapIndexed{index, recordResult -> if(recordResult == -1L) list[index] else null }
            .filterNotNull()
            .also { if(it.isNotEmpty()) update(it) }
    }

    @Query("""
        SELECT * FROM articles
    """)
    fun findArticles(): List<Article>

    @Query(
        """
            SELECT * FROM articles
            WHERE id = :id            
            LIMIT 1
        """
    )

    fun findArticleById(id: String): Article
}