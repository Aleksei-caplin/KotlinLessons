package ru.fom.myapplessons.data.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.fom.myapplessons.App
import ru.fom.myapplessons.data.local.dao.CivilizationDao
import ru.fom.myapplessons.data.local.entities.Civilization

object DbManager {
    val db = Room.databaseBuilder(
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

abstract class AppDb: RoomDatabase() {
    companion object{
        const val DATABASE_NAME = "ex_5.db"
        const val DATABASE_VERSION = 1
    }

    abstract fun civilizationDao(): CivilizationDao
}