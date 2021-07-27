package ru.fom.myapplessons.data.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.fom.myapplessons.App
import ru.fom.myapplessons.data.local.dao.CivilizationDao
import ru.fom.myapplessons.data.local.dao.SettingsDao
import ru.fom.myapplessons.data.local.entities.Civilization
import ru.fom.myapplessons.data.local.entities.SettingsEntity

object DbManager {
    val db = Room.databaseBuilder(
        App.applicationContext(),
        AppDb::class.java,
        AppDb.DATABASE_NAME
    ).build()
}

@Database(
    entities = [Civilization::class, SettingsEntity::class],
    version = AppDb.DATABASE_VERSION,
    exportSchema = false,
    views = []

)

@TypeConverters(DateConverter::class)
abstract class AppDb: RoomDatabase() {
    companion object{
        const val DATABASE_NAME = "ext_2.db"
        const val DATABASE_VERSION = 1
    }

    abstract fun civilizationDao(): CivilizationDao
    abstract fun settingsDao(): SettingsDao
}