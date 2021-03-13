package ru.fom.myapplessons.ui.civilization

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_civilizations_list.*
import ru.fom.myapplessons.R
import ru.fom.myapplessons.data.Civilization
import ru.fom.myapplessons.data.MenuItemHolder
import ru.fom.myapplessons.ui.base.BaseFragment
import ru.fom.myapplessons.ui.base.ToolbarBuilder
import ru.fom.myapplessons.viewmodel.EmpireViewModel

class CivilizationsListFragment : BaseFragment<EmpireViewModel>() {

    override val viewModel: EmpireViewModel by viewModels()
    override val layout: Int = R.layout.fragment_civilizations_list

    lateinit var civilizationsList: LiveData<List<Civilization>>



    private val civilizationAdapter = CivilizationAdapter {item ->
        val action = CivilizationsListFragmentDirections.actionCivilizationsListFragment2ToCivilizationSingleFragment22(
            item.name
        )
        main.navController.navigate(action.actionId, action.arguments)
        Toast.makeText(activity, item.name, Toast.LENGTH_LONG).show()
    }

    override val prepareToolbar: (ToolbarBuilder.() -> Unit) = {
        addMenuItem(
            MenuItemHolder(
                "Search",
                R.id.action_search,
                R.drawable.ic_baseline_search_24,
                R.layout.search_view_layout
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun setupViews() {
        initViewModel()
        //ProgressTask(main).execute()
        Log.d("M_fffff", filterName.toString())
        viewModel.getCivilizationData(filterName.orEmpty())
        val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        
        with(civilization_rw_list) {
            adapter = civilizationAdapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(divider)
        }

    }

    private fun initViewModel() {
        civilizationsList = viewModel.civilizationItems
        Log.d("M_get", civilizationsList.value.toString())
        civilizationsList.observe(main, Observer {
            civilizationAdapter.updateList(it)
        })
    }


}