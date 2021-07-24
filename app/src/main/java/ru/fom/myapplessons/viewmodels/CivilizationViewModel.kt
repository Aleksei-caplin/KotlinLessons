package ru.fom.myapplessons.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.fom.myapplessons.data.repository.AppRepository
import ru.fom.myapplessons.ui.state.MainState

class CivilizationViewModel: BaseViewModel() {

    private val repository = AppRepository
    private val defaultState = MainState.Loader
    private val action = MutableLiveData<MainState>()
    val state: LiveData<MainState>
        get() = action


}