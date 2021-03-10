package ru.fom.myapplessons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // получаем navController
        val host = supportFragmentManager.findFragmentById(R.id.navFragment) as NavHostFragment? ?: return
        val navController = host.navController

        // включаем боковое меню
        val sideBar = findViewById<NavigationView>(R.id.nav_view)
        sideBar?.setupWithNavController(navController)

        val appBArConfig = AppBarConfiguration(navController.graph, drawerLayout =  drawer_layout)
        val toolbar = toolbar

        toolbar.setupWithNavController(navController, appBArConfig)


    }

    override fun getDrawerToggleDelegate(): ActionBarDrawerToggle.Delegate? {
        return super.getDrawerToggleDelegate()

    }
}