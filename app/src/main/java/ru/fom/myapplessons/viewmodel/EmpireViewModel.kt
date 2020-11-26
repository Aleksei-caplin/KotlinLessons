package ru.fom.myapplessons.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import ru.fom.myapplessons.data.Civilization
import ru.fom.myapplessons.data.Sections
import ru.fom.myapplessons.data.Structure
import ru.fom.myapplessons.net.Common
import ru.fom.myapplessons.repository.EmpireRepository
import ru.fom.myapplessons.viewmodel.base.BaseViewModel

class EmpireViewModel: BaseViewModel() {

    private var repository = EmpireRepository(Common.retrofitService)
    private val civilizationItems = repository.getCivilizationsList()
    var fragmentState = ""

    // получаем данные для отрисовки списка цивилизаций
    fun getCivilizationData(): LiveData<List<Civilization>>{
        val result = MediatorLiveData<List<Civilization>>()

        val filterF = {

        }

        result.addSource(civilizationItems) { filterF.invoke() }
        return civilizationItems
    }



    // получаем данные для статических разделов
    fun getSections(): List<Sections> {
        return repository.getStaticSections()
    }

    fun getStructureData(): LiveData<List<Structure>> {
        return repository.getStructureList()
    }

}