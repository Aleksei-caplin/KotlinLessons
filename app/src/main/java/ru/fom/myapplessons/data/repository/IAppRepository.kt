package ru.fom.myapplessons.data.repository

import ru.fom.myapplessons.data.local.entities.Civilization
import ru.fom.myapplessons.data.remote.res.CivilizationDataRes

interface IAppRepository {
    suspend fun getCivilisations(): Int
    suspend fun insertCivilizationsToDb(civilizations: List<CivilizationDataRes>)
}