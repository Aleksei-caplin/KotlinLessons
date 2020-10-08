package ru.fom.myapplessons.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import ru.fom.myapplessons.data.Civilization
import ru.fom.myapplessons.net.Common
import ru.fom.myapplessons.repository.EmpireRepository

class EmpireViewModel(savedStateHandle: SavedStateHandle): ViewModel() {

    private lateinit var civilizationsLiveData: LiveData<List<Civilization>>
    private var repository = EmpireRepository(Common.retrofitService)

    init {
        civilizationsLiveData = repository.getCivilizationsList()
    }

}