package ru.fom.myapplessons.data.local

import android.annotation.SuppressLint
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.fom.myapplessons.App
import ru.fom.myapplessons.BuildConfig
import ru.fom.myapplessons.data.local.dao.CivilizationDao
import ru.fom.myapplessons.data.local.entities.Civilization

object DbManager {
    @SuppressLint("StaticFieldLeak")
    var db = Room.databaseBuilder(
        App.applicationContext(),
        AppDb::class.java,
        AppDb.DATABASE_NAME
    ).build()
}

@Database(
    entities = [Civilization::class],
    version = AppDb.DATABASE_VERSION,
    exportSchema = false,
    views = []
)

@TypeConverters(DateConverters::class)

abstract class AppDb: RoomDatabase() {
    companion object{
        const val DATABASE_NAME = BuildConfig.APPLICATION_ID + "db"
        const val DATABASE_VERSION = 1
    }

    abstract fun civilizationDao(): CivilizationDao
}