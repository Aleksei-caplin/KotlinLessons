package ru.fom.myapplessons

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import ru.fom.myapplessons.data.local.DbManager
import ru.fom.myapplessons.data.local.DbManager.db
import ru.fom.myapplessons.data.local.entities.Civilization
import ru.fom.myapplessons.databinding.ActivityMainBinding
import ru.fom.myapplessons.ui.base.BaseActivity
import ru.fom.myapplessons.ui.objects.AppDrawer
import ru.fom.myapplessons.viewmodel.MainViewModel

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var layoutDraver: DrawerLayout
    private lateinit var navView: NavigationView

class MainActivity : BaseActivity<MainViewModel>() {

    override val viewModel: MainViewModel by viewModels()
    override val layout: Int = R.layout.activity_main

    override fun onStart() {
        super.onStart()
        initFields()
        initFuns()


    }

    private fun initFields() {
        layoutDraver = findViewById(R.id.draver_layout)
        navView = findViewById(R.id.nav_view)
        navController = findNavController(R.id.nav_host)
    }

    private fun initFuns() {
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.structureListFragment,
            R.id.civilizationsListFragment2,
            R.id.tehnologyFragment,
            R.id.armyFragment
        ), layoutDraver)

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
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