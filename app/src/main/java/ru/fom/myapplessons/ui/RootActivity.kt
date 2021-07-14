package ru.fom.myapplessons.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.fom.myapplessons.R
import ru.fom.myapplessons.data.local.DbManager
import ru.fom.myapplessons.data.local.DbManager.db
import ru.fom.myapplessons.data.local.entities.Article
import ru.fom.myapplessons.data.local.entities.ArticleCounts
import ru.fom.myapplessons.data.local.entities.Author
import java.util.*

class RootActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            val expectedArticle = Article(
                "0",
                "test_article",
                "test description",
                author = Author("0", "", "John Week"),
                "0",
                "any",
                date = Date(),
                updatedAt = Date(),
            )
            val expectedArticle_1 = Article(
                "1",
                "gdgdgdrgdrgdrg",
                "test description",
                author = Author("0", "", "Chucj Norris"),
                "0",
                "any",
                date = Date(),
                updatedAt = Date(),
            )
            val expectedArticle_2 = Article(
                "2",
                "tyjyi678676i7",
                "test description",
                author = Author("0", "", "Bruse Li"),
                "0",
                "any",
                date = Date(),
                updatedAt = Date(),
            )

            val art_counts = ArticleCounts(
                "0",
                142,
                0,
                1577,
            )
            val art_counts_1 = ArticleCounts(
                    "1",
                14,
                10,
                15,
            )
            val art_counts_2 = ArticleCounts(
                "2",
                122,
                0,
                177,
            )

            //db.articlesDao().insert(expectedArticle)
            //db.articlesDao().insert(expectedArticle_1)
            //db.articlesDao().insert(expectedArticle_2)
            //db.articlesDao().upsert(listOf(expectedArticle, expectedArticle_1, expectedArticle_2))
            //db.articleCountsDao().upsert(listOf(art_counts, art_counts_1, art_counts_2))

            //db.articleCountsDao().incrementLike("1")

            //db.articlesDao().delete(expectedArticle)

        }
    }
}