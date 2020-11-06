package ru.fom.myapplessons.viewmodel.civilization

import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.fom.myapplessons.MainActivity
import ru.fom.myapplessons.R
import ru.fom.myapplessons.data.Civilization
import ru.fom.myapplessons.net.Common
import ru.fom.myapplessons.repository.EmpireRepository
import ru.fom.myapplessons.viewmodel.base.BaseViewModel

class CivilizationsViewModel: BaseViewModel() {

    private var repository = EmpireRepository(Common.retrofitService)

    // получаем данные для отрисовки списка цивилизаций
    fun getCivilizationData(): LiveData<List<Civilization>> {
        return repository.getCivilizationsList()
    }
}