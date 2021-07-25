package ru.fom.myapplessons.data.repository

import io.reactivex.rxjava3.core.Single
import ru.fom.myapplessons.data.local.entities.Civilization
import ru.fom.myapplessons.data.remote.res.CivilizationDataRes
import ru.fom.myapplessons.data.remote.res.CivilizationList

interface IAppRepository {
    suspend fun getCivilisations(): Int
    fun getCivilizationsByRx(): Single<CivilizationList>
    fun insertCivilizationsToDb(civilizations: List<CivilizationDataRes>)
}