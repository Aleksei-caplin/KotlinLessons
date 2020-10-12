package ru.fom.myapplessons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.SectionIndexer
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ru.fom.myapplessons.data.Civilization
import ru.fom.myapplessons.data.Sections
import ru.fom.myapplessons.ui.adapter.SectionsAdapter
import ru.fom.myapplessons.ui.fragments.civilization.CivilizationsListFragment
import ru.fom.myapplessons.ui.fragments.structures.StructureListFragment
import ru.fom.myapplessons.utils.APP_ACTIVITY
import ru.fom.myapplessons.utils.replaceFragment
import ru.fom.myapplessons.viewmodel.EmpireViewModel

    lateinit var sectionList: List<Sections>
    lateinit var civilizationsList: LiveData<List<Civilization>>

    val viewModel: EmpireViewModel by lazy {
        ViewModelProvider(APP_ACTIVITY).get(EmpireViewModel::class.java)
    }



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        APP_ACTIVITY = this

        civilizationsList = viewModel.getCivilizationData()
        sectionList = viewModel.getSections()

        showSectionList() // отрисовываем список разделов
        showFragment() // отрисовываем текущий врагмент
    }

    private fun showSectionList() {

        val sectionAdapter = SectionsAdapter(sectionList){
            showFragment(it.code)
        }

        with(rv_sections) {
            adapter = sectionAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        }
    }


    private fun showFragment(fragment_name: String = "") {
        Log.d("M_showFragment", fragment_name)
        when(fragment_name){
            "building_list" -> replaceFragment(R.id.wrap_content, StructureListFragment())
            "tehnology_list" -> replaceFragment(R.id.wrap_content, StructureListFragment())
            "army_list" -> replaceFragment(R.id.wrap_content, StructureListFragment())
            else -> replaceFragment(R.id.wrap_content, CivilizationsListFragment())
        }
    }
}