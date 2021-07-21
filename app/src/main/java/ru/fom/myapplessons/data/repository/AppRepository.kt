package ru.fom.myapplessons.data.repository

import ru.fom.myapplessons.data.local.DbManager.db
import ru.fom.myapplessons.data.local.entities.Civilization
import ru.fom.myapplessons.data.remote.NetworkManager
import ru.fom.myapplessons.data.remote.res.CivilizationDataRes
import ru.fom.myapplessons.extensions.data.toCivilization


object AppRepository: IAppRepository {

    private val network = NetworkManager.api
    private val civilizationDao = db.civilizationDao()

    override suspend fun getCivilisations(): Int {
        val items = network.getCivilizationList()
        if( items.civilizations.isNotEmpty() ) insertCivilizationsToDb(items.civilizations)
        return items.civilizations.size
    }

    override suspend fun insertCivilizationsToDb(civilizations: List<CivilizationDataRes>) {
        civilizationDao.upsert( civilizations.map { it.toCivilization() })
    }
}