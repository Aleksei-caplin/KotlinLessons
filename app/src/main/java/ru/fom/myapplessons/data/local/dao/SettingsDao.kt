package ru.fom.myapplessons.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Single

import ru.fom.myapplessons.data.local.entities.SettingsEntity

@Dao
interface SettingsDao: BaseDao<SettingsEntity> {

    // выборка всех записей из таблицы
    @Query("""
        SELECT * FROM app_settings
    """)
    fun getAllSettings(): Single<SettingsEntity>

    // Добавление одной записи в таблицу
    @Insert
    fun addDefaultSettings(vararg settingsEntity: SettingsEntity)
}