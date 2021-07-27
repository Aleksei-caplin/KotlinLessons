package ru.fom.myapplessons.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.fom.myapplessons.data.repository.AppRepository
import ru.fom.myapplessons.ui.state.MainState

class CivilizationViewModel: BaseViewModel() {

    private val repository = AppRepository
    private val defaultState = MainState.Loader
    private val action = MutableLiveData<MainState>()
    val state: LiveData<MainState>
        get() = action



    init {
        //actualDbSettings()
        loadCivilizations()
    }

    /*private fun actualDbSettings() =
        repository.getSettingsByRx()
            .doOnSubscribe {  }
            .subscribe({
                val newState = MainState.AppSettings(it)
                action.value = newState

            }, {
                Log.d("M_sett_m_error", it.message.toString())
            })*/



    private fun loadCivilizations() =
        repository.getCivilizationsByRx()
            .doOnSubscribe { action.value = defaultState }
            .subscribe({
                val newState = MainState.Result(it)
                action.value = newState
            }, {
                action.value = MainState.Error("Что-то пошло не по плану", it)
            })



}