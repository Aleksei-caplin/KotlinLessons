package ru.fom.myapplessons.viewmodels

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
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

    @SuppressLint("CheckResult")
    fun loadCivilizations() {
        repository.getCivilizationsByRx()
            .doOnSubscribe { action.value = defaultState }
            .subscribe({
                val newState = MainState.Result(it)
                action.value = newState
            }, {
                action.value = MainState.Error("Что-то пошло не по плану", it)
                it.printStackTrace()
            })
    }


}