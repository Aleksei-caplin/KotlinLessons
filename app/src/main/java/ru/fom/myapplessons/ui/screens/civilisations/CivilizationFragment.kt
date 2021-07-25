package ru.fom.myapplessons.ui.screens.civilisations

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.fom.myapplessons.R
import ru.fom.myapplessons.data.local.DbManager.db
import ru.fom.myapplessons.data.local.entities.Civilization
import ru.fom.myapplessons.data.local.entities.Cost
import ru.fom.myapplessons.data.local.entities.Warrior
import ru.fom.myapplessons.databinding.FragmentCivilizationBinding
import ru.fom.myapplessons.viewmodels.CivilizationViewModel


class CivilizationFragment : Fragment() {

    private var _binding: FragmentCivilizationBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CivilizationViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCivilizationBinding.inflate(inflater, container, false)
        return  binding.root
        //return inflater.inflate(R.layout.fragment_civilization, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val res = viewModel.state
        Log.d("M_fff", res.toString())
    }
}