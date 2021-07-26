package ru.fom.myapplessons.data.repository


import android.util.Log
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.fom.myapplessons.data.local.DbManager.db
import ru.fom.myapplessons.data.local.entities.Civilization
import ru.fom.myapplessons.data.remote.NetworkManager
import ru.fom.myapplessons.data.remote.res.CivilizationDataRes
import ru.fom.myapplessons.data.remote.res.CivilizationList
import ru.fom.myapplessons.extensions.data.toCivilization
import java.util.concurrent.TimeUnit


object AppRepository: IAppRepository {

    private val network = NetworkManager.api
    private val civilizationDao = db.civilizationDao()

    override suspend fun getCivilisations(): Int {
        TODO()
    }

    /*override suspend fun getCivilisations(): Int {
        val items = network.getCivilizationList()
        if( items.civilizations.isNotEmpty() ) insertCivilizationsToDb(items.civilizations)
        return items.civilizations.size
    }*/

    override fun getCivilizationsByRx(): Single<List<Civilization>> =
        network.getCivilizationList()
            .doOnSuccess { civ: CivilizationList ->
                if(civ.civilizations.isNotEmpty()) insertCivilizationsToDb(civ.civilizations)
            }
            .doOnError {
                Log.e("M_error_rx", it.message.toString())
            }
            .delay(5, TimeUnit.SECONDS)
            .flatMap {

                Single.just(civilizationDao.findCivilizations())
            }
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())



    override fun insertCivilizationsToDb(civilizations: List<CivilizationDataRes>) {
        civilizationDao.upsert( civilizations.map { it.toCivilization() })
    }

    override fun getCivilizationsFromDB(): List<Civilization> {
        TODO("Not yet implemented")
    }


}