package ru.fom.myapplessons

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import ru.fom.myapplessons.data.Civilization
import ru.fom.myapplessons.databinding.ActivityMainBinding
import ru.fom.myapplessons.ui.objects.AppDrawer
import ru.fom.myapplessons.utils.APP_ACTIVITY
import ru.fom.myapplessons.viewmodel.EmpireViewModel

    lateinit var civilizationsList: LiveData<List<Civilization>>

    //lateinit var sectionList: List<Sections>
    //lateinit var buildingList: LiveData<List<Structure>>
    //lateinit var technologyList: LiveData<List<Technology>>
    //lateinit var unitList: LiveData<List<Unit>>*/

    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbar: Toolbar
    lateinit var navController: NavController
    private lateinit var appDrawer: AppDrawer

   /* val viewModel: EmpireViewModel by lazy {
        ViewModelProvider(APP_ACTIVITY).get(EmpireViewModel::class.java)
    }*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        APP_ACTIVITY = this

        //sectionList = viewModel.getSections()
        //civilizationsList = viewModel.getCivilizationData()
        //buildingList = viewModel.getStructureData()

        //showSectionList() // отрисовываем список разделов
        //showFragment(fragmentState) // отрисовываем текущий (восстановленный) врагмент
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFuns()
    }

    private fun initFields() {
        toolbar = binding.mainToolbar
        navController = Navigation.findNavController(APP_ACTIVITY, R.id.nav_host)
        appDrawer = AppDrawer(navController, toolbar)



    }

    private fun initFuns() {
        setSupportActionBar(toolbar)
        appDrawer.createSideMenu()
    }




    /*private fun showSectionList() {

        val sectionAdapter = SectionsAdapter(sectionList){
            fragmentState = it.code
            showFragment(it.code)
        }

        with(rv_sections) {
            adapter = sectionAdapter
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
    }*/

    /*private fun showFragment(fragment_name: String = "") {
        Log.d("M_showFragment", fragment_name)
        when(fragment_name){
            "building_list" -> replaceFragment(R.id.wrap_content, StructureListFragment())
            "tehnology_list" -> replaceFragment(R.id.wrap_content, StructureListFragment())
            "army_list" -> replaceFragment(R.id.wrap_content, StructureListFragment())
            else -> replaceFragment(R.id.wrap_content, CivilizationsListFragment())
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("fragment_name", fragmentState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        fragmentState = savedInstanceState.get("fragment_name").toString()
    }*/
}