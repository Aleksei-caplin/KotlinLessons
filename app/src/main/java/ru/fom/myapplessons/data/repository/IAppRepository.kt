package ru.fom.myapplessons.data.repository


import io.reactivex.Single
import ru.fom.myapplessons.data.local.entities.Civilization
import ru.fom.myapplessons.data.local.entities.SettingsEntity
import ru.fom.myapplessons.data.remote.res.CivilizationDataRes

interface IAppRepository {
    suspend fun getCivilisations(): Int
    fun getCivilizationsByRx(): Single<List<Civilization>>
    fun getSettingsByRx(): Single<SettingsEntity>
    fun insertCivilizationsToDb(civilizations: List<CivilizationDataRes>)
    fun getCivilizationsFromDB(): List<Civilization>
}