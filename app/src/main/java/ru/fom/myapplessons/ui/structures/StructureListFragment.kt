package ru.fom.myapplessons.ui.structures

//import ru.fom.myapplessons.buildingList

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavOptions
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_structure_list.*
import ru.fom.myapplessons.R
import ru.fom.myapplessons.data.Structure
import ru.fom.myapplessons.ui.base.BaseFragment
import ru.fom.myapplessons.viewmodel.EmpireViewModel


class StructureListFragment : BaseFragment<EmpireViewModel>() {

    override val viewModel: EmpireViewModel by viewModels()
    override val layout = R.layout.fragment_structure_list

    lateinit var structureList: LiveData<List<Structure>>
    private var navBuilder = NavOptions.Builder()

    private val structureAdapter = StructureAdapter { item ->
        val action = StructureListFragmentDirections.actionStructureListFragment3ToStructureSingleFragment(
            item.name,
            item.id
        )
        navBuilder.setEnterAnim(R.anim.slide_left).setExitAnim(R.anim.slide_right).setPopEnterAnim(R.anim.slide_left).setPopExitAnim(R.anim.slide_right)
        main.navController.navigate(action.actionId, action.arguments, navBuilder.build())
        Toast.makeText(activity, item.name, Toast.LENGTH_LONG).show()
    }

    override fun setupViews() {
        Log.d("M_filter", filterName.toString())
        initViewModel()
        val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)

        with(structure_rw_list) {
            adapter = structureAdapter
            layoutManager = LinearLayoutManager(main)
            addItemDecoration(divider)
        }
    }

    private fun initViewModel() {


        structureList = viewModel.getStructureData()
        structureList.observe(main, Observer {
            structureAdapter.updateList(it)
        })
    }
}