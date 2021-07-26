package ru.fom.myapplessons.ui.screens.civilisations

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.fom.myapplessons.R
import ru.fom.myapplessons.data.local.DbManager.db
import ru.fom.myapplessons.data.local.entities.Civilization
import ru.fom.myapplessons.data.local.entities.Cost
import ru.fom.myapplessons.data.local.entities.Warrior
import ru.fom.myapplessons.databinding.FragmentCivilizationBinding
import ru.fom.myapplessons.ui.adapters.CivilizationAdapter
import ru.fom.myapplessons.ui.state.MainState
import ru.fom.myapplessons.viewmodels.CivilizationViewModel


class CivilizationFragment : Fragment() {

    private var _binding: FragmentCivilizationBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CivilizationViewModel by viewModels()

    val civAdapter = CivilizationAdapter {
        Toast.makeText(activity, "sfsdfsdsdfsd", Toast.LENGTH_LONG)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCivilizationBinding.inflate(inflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val divider = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        
        viewModel.state.observe(viewLifecycleOwner, ::renderState)

        binding.recycler.adapter = civAdapter
        binding.recycler.layoutManager = LinearLayoutManager(activity)
        binding.recycler.addItemDecoration(divider)
    }

    private fun renderState(state: MainState) {
        binding.progressProduct.isVisible = state == MainState.Loader
        Log.d("M_start", "1")
        if(state is MainState.Result){

            civAdapter.updateList(state.civilizationItems)
        }
    }

   /* override fun onDestroy() {
        binding.recycler.adapter = null
        _binding = null
        super.onDestroy()
    }*/
}