package ru.fom.myapplessons.viewmodels

import android.util.Log
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
        loadCivilizations()
    }

    private fun loadCivilizations() {
        Log.e("M_succ", "load")
        repository.getCivilizationsByRx()
            .doOnSubscribe { action.value = defaultState }
            .subscribe({
                Log.e("M_succ", it.civilizations.toString())
                val newState = MainState.Result(it)
                action.value = newState
            }, {
                Log.e("M_err", it.message.toString())
            })

    }


}