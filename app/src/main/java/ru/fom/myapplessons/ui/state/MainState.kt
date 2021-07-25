package ru.fom.myapplessons.ui.state

import ru.fom.myapplessons.data.local.entities.Civilization
import ru.fom.myapplessons.data.remote.res.CivilizationList

sealed class MainState {
    object Loader: MainState()
    data class Error(val message: String, val error: Throwable): MainState()
    data class Result(
        val civilizationItem: CivilizationList
    ): MainState()
}