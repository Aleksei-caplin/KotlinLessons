package ru.fom.myapplessons.data.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.fom.myapplessons.App
import ru.fom.myapplessons.BuildConfig
import ru.fom.myapplessons.data.local.dao.ArticlesDao
import ru.fom.myapplessons.data.local.entities.Article

object DbManager {
    val db = Room.databaseBuilder(
        App.applicationContext(),
        AppDb::class.java,
        AppDb.DATABASE_NAME
    ).build()
}

@Database(
    entities = [Article::class],
    version = AppDb.DATABASE_VERSION,
    exportSchema = false,
    views = []
)
abstract class AppDb: RoomDatabase() {
    companion object {
        const val DATABASE_NAME: String = BuildConfig.APPLICATION_ID + ".db"
        const val DATABASE_VERSION = 1
    }

    abstract fun articlesDao(): ArticlesDao

}