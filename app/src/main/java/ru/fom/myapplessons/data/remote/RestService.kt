package ru.fom.myapplessons.data.remote


import io.reactivex.Single
import retrofit2.http.GET
import ru.fom.myapplessons.data.remote.res.CivilizationDataRes
import ru.fom.myapplessons.data.remote.res.CivilizationList

interface RestService {

    @GET("civilizations")
    fun getCivilizationList() : Single<CivilizationList>
}