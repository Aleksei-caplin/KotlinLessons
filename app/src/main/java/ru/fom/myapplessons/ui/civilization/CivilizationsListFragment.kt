package ru.fom.myapplessons.ui.civilization

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_civilizations_list.*
import ru.fom.myapplessons.R
import ru.fom.myapplessons.data.Civilization
import ru.fom.myapplessons.navController

import ru.fom.myapplessons.ui.base.BaseFragment
import ru.fom.myapplessons.utils.APP_ACTIVITY
import ru.fom.myapplessons.viewmodel.civilization.CivilizationsViewModel

class CivilizationsListFragment : BaseFragment<CivilizationsViewModel>() {

    override val viewModel: CivilizationsViewModel by viewModels()
    override val layout: Int = R.layout.fragment_civilizations_list

    lateinit var civilizationsList: LiveData<List<Civilization>>

    private val civilizationAdapter = CivilizationAdapter {item ->
        val action = CivilizationsListFragmentDirections.actionCivilizationsListFragment2ToCivilizationSingleFragment22(
            item.name
        )
        navController.navigate(action.actionId, action.arguments)
        Toast.makeText(activity, item.name, Toast.LENGTH_LONG).show()
    }

    override fun setupViews() {
        initViewModel()
        val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)

        with(civilization_rw_list) {
            adapter = civilizationAdapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(divider)
        }
    }

    private fun initViewModel() {
        civilizationsList = viewModel.getCivilizationData()
        civilizationsList.observe(APP_ACTIVITY, Observer {
            civilizationAdapter.updateList(it)
        })
    }
}