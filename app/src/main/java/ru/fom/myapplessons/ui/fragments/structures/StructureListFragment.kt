package ru.fom.myapplessons.ui.fragments.structures

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.fom.myapplessons.R



class StructureListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initViews()
        initViewModel()
        return inflater.inflate(R.layout.fragment_structure_list, container, false)
    }

    private fun initViewModel() {

    }

    private fun initViews() {

    }


}