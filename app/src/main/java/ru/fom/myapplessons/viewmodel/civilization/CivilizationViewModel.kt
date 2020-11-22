package ru.fom.myapplessons.viewmodel.civilization

import androidx.lifecycle.SavedStateHandle
import ru.fom.myapplessons.net.Common
import ru.fom.myapplessons.repository.EmpireRepository
import ru.fom.myapplessons.viewmodel.base.BaseViewModel

class CivilizationViewModel(
    handle: SavedStateHandle,
    private val articleId: String
): BaseViewModel() {

    private var repository = EmpireRepository(Common.retrofitService)


}