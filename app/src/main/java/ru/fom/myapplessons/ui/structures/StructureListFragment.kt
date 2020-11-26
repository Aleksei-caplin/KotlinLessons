package ru.fom.myapplessons.ui.structures

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_structure_list.*
import ru.fom.myapplessons.R
import ru.fom.myapplessons.data.Structure
import ru.fom.myapplessons.navController
import ru.fom.myapplessons.ui.base.BaseFragment
//import ru.fom.myapplessons.buildingList
import ru.fom.myapplessons.utils.APP_ACTIVITY
import ru.fom.myapplessons.viewmodel.EmpireViewModel
import ru.fom.myapplessons.viewmodel.civilization.CivilizationsViewModel


class StructureListFragment : BaseFragment<EmpireViewModel>() {

    override val viewModel: EmpireViewModel by viewModels()
    override val layout = R.layout.fragment_structure_list

    lateinit var structureList: LiveData<List<Structure>>

    private val structureAdapter = StructureAdapter { item ->
        val action = StructureListFragmentDirections.actionStructureListFragment3ToStructureSingleFragment(
            item.name,
            item.id
        )
        navController.navigate(action.actionId, action.arguments)
        Toast.makeText(activity, item.name, Toast.LENGTH_LONG).show()
    }

    override fun setupViews() {
        Log.d("M_filter", filterName.toString())
        initViewModel()
        val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)

        with(structure_rw_list) {
            adapter = structureAdapter
            layoutManager = LinearLayoutManager(APP_ACTIVITY)
            addItemDecoration(divider)
        }
    }

    private fun initViewModel() {


        structureList = viewModel.getStructureData()
        structureList.observe(APP_ACTIVITY, Observer {
            structureAdapter.updateList(it)
        })
    }
}