package ru.fom.myapplessons.ui.fragments.structures

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_structure_list.*
import ru.fom.myapplessons.R
//import ru.fom.myapplessons.buildingList
import ru.fom.myapplessons.fragmentState
import ru.fom.myapplessons.ui.adapter.StructureAdapter
import ru.fom.myapplessons.utils.APP_ACTIVITY


class StructureListFragment : Fragment() {

    private lateinit var structureAdapter: StructureAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_structure_list, container, false)
    }

    override fun onResume() {
        super.onResume()
        //initViews()
        //initViewModel()
    }

    private fun initViews() {
        structureAdapter = StructureAdapter {
            Toast.makeText(APP_ACTIVITY, it.name, Toast.LENGTH_LONG).show()
        }

        val divider = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)

        with(structure_rw_list) {
            adapter = structureAdapter
            layoutManager = LinearLayoutManager(APP_ACTIVITY)
            addItemDecoration(divider)
        }
    }

    /*private fun initViewModel() {
        buildingList.observe(APP_ACTIVITY, Observer {
            structureAdapter.updateList(it)
        })
    }*/




}