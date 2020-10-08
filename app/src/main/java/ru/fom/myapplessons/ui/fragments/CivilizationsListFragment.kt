package ru.fom.myapplessons.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_civilizations_list.*
import ru.fom.myapplessons.MainActivity
import ru.fom.myapplessons.R
import ru.fom.myapplessons.data.Civilization
import ru.fom.myapplessons.net.Common
import ru.fom.myapplessons.repository.EmpireRepository
import ru.fom.myapplessons.ui.adapter.CivilizationAdapter
import ru.fom.myapplessons.viewmodel.EmpireViewModel

class CivilizationsListFragment : Fragment() {

    //private val civilizationViewModel: EmpireViewModel by viewModels()
    private lateinit var civilizationsList: LiveData<List<Civilization>>
    private lateinit var civilizationAdapter: CivilizationAdapter
    private var repository = EmpireRepository(Common.retrofitService)

    init {
        civilizationsList = repository.getCivilizationsList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_civilizations_list, container, false)
    }

    override fun onResume() {
        super.onResume()
        initViews()
        initViewModel()
    }

    private fun initViews() {
        civilizationAdapter = CivilizationAdapter {
            Toast.makeText(activity, "Текст", Toast.LENGTH_LONG).show()
        }

        val divider = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)

        with(civilization_rw_list) {
            adapter = civilizationAdapter
            layoutManager = LinearLayoutManager(activity)
            addItemDecoration(divider)
        }
    }

    private fun initViewModel() {
        civilizationsList.observe(this, Observer {
            civilizationAdapter.updateList(it)
        })
    }

}