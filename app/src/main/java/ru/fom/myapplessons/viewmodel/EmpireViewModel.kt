package ru.fom.myapplessons.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.fom.myapplessons.data.Civilization
import ru.fom.myapplessons.data.Sections
import ru.fom.myapplessons.data.Structure
import ru.fom.myapplessons.net.Common
import ru.fom.myapplessons.repository.EmpireRepository
import ru.fom.myapplessons.viewmodel.base.BaseViewModel

class EmpireViewModel: BaseViewModel() {

    private var repository = EmpireRepository(Common.retrofitService)
    val civilizationItems = MediatorLiveData<List<Civilization>>()

    // получаем данные для отрисовки списка цивилизаций
    fun getCivilizationData(filterName: String = ""): LiveData<List<Civilization>>{
        val result = repository.getCivilizationsList()

        val filterF:(result:List<Civilization>) -> List<Civilization> = {
            if (filterName.isEmpty()) {
                result.value.orEmpty()
            }else{
                it.filter { it.expansion == filterName }
            }
        }
        Log.d("M_ggggggggggg", result.value.toString())
        //civilizationItems.value = filterF.invoke(result.value.orEmpty())
        //civilizationItems.value = listOf(Civilization(id=1, name="Aztecs", expansion="The Conquerors", army_type="Infantry and Monk"))
        civilizationItems.addSource(result) {
            civilizationItems.value = filterF.invoke(it)
        }
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