package ru.fom.myapplessons.net

import retrofit2.Call
import retrofit2.http.GET
import ru.fom.myapplessons.data.Civilization
import ru.fom.myapplessons.data.CivilizationList

interface EmpireInterface {

    @GET("civilizations")
    fun getAllCivilizations(): Call<CivilizationList>
}