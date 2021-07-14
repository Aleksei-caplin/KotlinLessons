package ru.fom.myapplessons.data.local

import androidx.room.*
import ru.fom.myapplessons.App
import ru.fom.myapplessons.BuildConfig
import ru.fom.myapplessons.data.local.dao.ArticleCountsDao
import ru.fom.myapplessons.data.local.dao.ArticlesDao
import ru.fom.myapplessons.data.local.entities.Article
import ru.fom.myapplessons.data.local.entities.ArticleCounts
import ru.fom.myapplessons.data.local.entities.ArticleItem

object DbManager {
    val db = Room.databaseBuilder(
        App.applicationContext(),
        AppDb::class.java,
        AppDb.DATABASE_NAME
    ).build()
}

@Database(
    entities = [Article::class, ArticleCounts::class],
    version = AppDb.DATABASE_VERSION,
    exportSchema = false,
    views = [ArticleItem::class]
)

@TypeConverters(DateConverter::class)
abstract class AppDb: RoomDatabase() {
    companion object {
        const val DATABASE_NAME: String = "table_4.db"
        const val DATABASE_VERSION = 1
    }

    abstract fun articlesDao(): ArticlesDao
    abstract fun articleCountsDao(): ArticleCountsDao
}