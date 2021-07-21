package ru.fom.myapplessons.data.remote

import retrofit2.http.GET
import ru.fom.myapplessons.data.local.entities.Civilization
import ru.fom.myapplessons.data.remote.res.CivilizationList

interface RestService {

    @GET("civilizations")
    suspend fun getCivilizationList() : CivilizationList
}