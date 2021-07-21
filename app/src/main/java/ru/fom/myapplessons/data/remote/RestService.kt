package ru.fom.myapplessons.data.remote

import retrofit2.http.GET
import ru.fom.myapplessons.data.local.entities.Civilization

interface RestService {

    @GET("civilizations")
    suspend fun getCivilizationList() : List<Civilization>
}