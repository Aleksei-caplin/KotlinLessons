package ru.fom.myapplessons.ui.civilization

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_civilizations_list.*
import ru.fom.myapplessons.R
import ru.fom.myapplessons.civilizationsList
import ru.fom.myapplessons.net.Common
import ru.fom.myapplessons.repository.EmpireRepository
import ru.fom.myapplessons.ui.base.BaseFragment
import ru.fom.myapplessons.utils.APP_ACTIVITY
import ru.fom.myapplessons.viewmodel.civilization.CivilizationViewModel

class CivilizationsListFragment : BaseFragment<CivilizationViewModel>() {

    override val viewModel: CivilizationViewModel by viewModels()
    override val layout: Int = R.layout.fragment_civilizations_list

    private val civilizationAdapter = CivilizationAdapter {
        Toast.makeText(activity, it.name, Toast.LENGTH_LONG).show()
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

        civilizationsList.observe(APP_ACTIVITY, Observer {
            civilizationAdapter.updateList(it)
        })
    }
}