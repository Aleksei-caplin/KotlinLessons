package ru.fom.myapplessons.data.repository

import ru.fom.myapplessons.data.local.DbManager.db
import ru.fom.myapplessons.data.local.entities.Civilization
import ru.fom.myapplessons.data.remote.NetworkManager


object AppRepository: IAppRepository {

    private val network = NetworkManager.api
    private val civilizationDao = db.civilizationDao()

    override suspend fun getCivilisations(): Int {
        val items = network.getCivilizationList()
        //if( items.isNotEmpty() ) InsertCivilizationsToDb(items)
        return items.size
    }

    override suspend fun insertCivilizationsToDb(civilizations: List<Civilization>) {
        //civilizationDao.upsert(civilizations.map {  })
    }
}