package ru.fom.myapplessons.viewmodel.base

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import ru.fom.myapplessons.viewmodel.civilization.CivilizationViewModel
import ru.fom.myapplessons.viewmodel.civilization.CivilizationsViewModel

class ViewModelFactory(
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle = bundleOf(),
    private val params: Any
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        if (modelClass.isAssignableFrom(CivilizationViewModel::class.java)) {
            return CivilizationViewModel(
                handle,
                params as String
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}