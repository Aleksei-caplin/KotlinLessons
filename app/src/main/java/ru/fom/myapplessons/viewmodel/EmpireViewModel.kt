package ru.fom.myapplessons.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.fom.myapplessons.data.Civilization
import ru.fom.myapplessons.data.Sections
import ru.fom.myapplessons.data.Structure
import ru.fom.myapplessons.net.Common
import ru.fom.myapplessons.repository.EmpireRepository

class EmpireViewModel: ViewModel() {

    private var repository = EmpireRepository(Common.retrofitService)
    var fragmentState = ""

    // получаем данные для отрисовки списка цивилизаций
    fun getCivilizationData(): LiveData<List<Civilization>>{
        return repository.getCivilizationsList()
    }

    // получаем данные для статических разделов
    fun getSections(): List<Sections> {
        return repository.getStaticSections()
    }

    fun getStructureData(): LiveData<List<Structure>> {
        return repository.getStructureList()
    }

}