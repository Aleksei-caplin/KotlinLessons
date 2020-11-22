package ru.fom.myapplessons.net

import retrofit2.create

object Common {

    private const val BASE_EMPIRE_URL = "https://age-of-empires-2-api.herokuapp.com/api/v1/"

    val retrofitService: EmpireInterface
        get() = RetrofitApiClient.getClient(BASE_EMPIRE_URL).create(EmpireInterface::class.java)
}