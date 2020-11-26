package ru.fom.myapplessons.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.fom.myapplessons.data.*
import ru.fom.myapplessons.net.Common
import ru.fom.myapplessons.net.EmpireInterface

class EmpireRepository(private val retrofitService: EmpireInterface) {

    fun getCivilizationsList(): LiveData<List<Civilization>> {
        val data = MutableLiveData<List<Civilization>>()

        retrofitService.getAllCivilizations().enqueue(object : Callback<CivilizationList>{
            override fun onResponse(
                call: Call<CivilizationList>,
                response: Response<CivilizationList>
            ) {
                data.value = response.body()!!.civilizations
            }

            override fun onFailure(call: Call<CivilizationList>, t: Throwable) {
                Log.d("M_failure", t.message.toString())
            }

        })
        return data
    }

    fun getStaticSections(): List<Sections> {
        return DataHolder.staticSections()
    }

    fun getStructureList(): LiveData<List<Structure>> {
        val data = MutableLiveData<List<Structure>>()

        retrofitService.getAllStructures().enqueue(object: Callback<StructureList>{
            override fun onResponse(
                call: Call<StructureList>,
                response: Response<StructureList>
            ) {
                data.value = response.body()!!.structures
            }

            override fun onFailure(call: Call<StructureList>, t: Throwable) {
                Log.d("M_failure",t.message.toString())
            }

        })
        return data
    }
}