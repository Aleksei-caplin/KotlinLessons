package ru.fom.myapplessons.ui.state

import ru.fom.myapplessons.data.local.entities.Civilization
import ru.fom.myapplessons.data.local.entities.SettingsEntity
import ru.fom.myapplessons.data.remote.res.CivilizationDataRes
import ru.fom.myapplessons.data.remote.res.CivilizationList
import java.util.*

sealed class MainState {
    object Loader: MainState()
    data class Error(
        val message: String,
        val error: Throwable
    ): MainState()
    data class Result(
        val civilizationItems: List<Civilization>
    ): MainState()
}