package ru.fom.myapplessons.net

import retrofit2.Call
import retrofit2.http.GET
import ru.fom.myapplessons.data.Civilization
import ru.fom.myapplessons.data.CivilizationList
import ru.fom.myapplessons.data.Structure
import ru.fom.myapplessons.data.StructureList

interface EmpireInterface {

    @GET("civilizations")
    fun getAllCivilizations(): Call<CivilizationList>

    @GET("structures")
    fun getAllStructures(): Call<StructureList>
}