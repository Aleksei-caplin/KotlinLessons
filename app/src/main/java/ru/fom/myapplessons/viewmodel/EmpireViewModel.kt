package ru.fom.myapplessons.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.fom.myapplessons.data.Civilization
import ru.fom.myapplessons.data.Sections
import ru.fom.myapplessons.net.Common
import ru.fom.myapplessons.repository.EmpireRepository

class EmpireViewModel: ViewModel() {

    private var repository = EmpireRepository(Common.retrofitService)

    // получаем данные для отрисовки списка цивилизаций
    fun getCivilizationData(): LiveData<List<Civilization>>{
        return repository.getCivilizationsList()
    }

    fun getNewCivil(): LiveData<List<Civilization>> {
        val newData = MutableLiveData<List<Civilization>>()
        newData.value = listOf(Civilization(222, "test", "test_exp"))
        return newData
    }

    // получаем данные для статических разделов
    fun getSections(): List<Sections> {
        return repository.getStaticSections()
    }

}