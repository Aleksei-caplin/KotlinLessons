package ru.fom.myapplessons.ui.fragments.civilization

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_civilizations_list.*
import ru.fom.myapplessons.*
import ru.fom.myapplessons.R
import ru.fom.myapplessons.data.Civilization
import ru.fom.myapplessons.net.Common
import ru.fom.myapplessons.repository.EmpireRepository
import ru.fom.myapplessons.ui.`interface`.Communicator
import ru.fom.myapplessons.ui.adapter.CivilizationAdapter
import ru.fom.myapplessons.utils.APP_ACTIVITY
import ru.fom.myapplessons.viewmodel.EmpireViewModel

class CivilizationsListFragment : Fragment() {

    private lateinit var civilizationAdapter: CivilizationAdapter
    private var repository = EmpireRepository(Common.retrofitService)
    lateinit var communicator: Communicator
    var count = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_civilizations_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
        initViews()
        initViewModel()
    }

    private fun initViews() {
        civilizationAdapter = CivilizationAdapter {
            Toast.makeText(activity, it.name, Toast.LENGTH_LONG).show()
        }

        val divider = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)

        with(civilization_rw_list) {
            adapter = civilizationAdapter
            layoutManager = LinearLayoutManager(activity)
            addItemDecoration(divider)
        }
    }

    private fun initViewModel() {
        civilizationsList.observe(APP_ACTIVITY, Observer {
            civilizationAdapter.updateList(it)
        })
    }
}