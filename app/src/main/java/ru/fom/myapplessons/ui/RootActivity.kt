package ru.fom.myapplessons.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import ru.fom.myapplessons.R
import ru.fom.myapplessons.data.remote.res.CivilizationDataRes
import ru.fom.myapplessons.data.repository.AppRepository
import ru.fom.myapplessons.databinding.ActivityRootBinding

class RootActivity : AppCompatActivity() {

    lateinit var binding: ActivityRootBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var layoutDrawer: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var navController: NavController

    val repo = AppRepository
    val tt = listOf<CivilizationDataRes>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRootBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
    }

    override fun onStart() {
        super.onStart()

        navController = Navigation.findNavController(this, R.id.nav_host)
        layoutDrawer = findViewById(R.id.draver_layout)
        navView = findViewById(R.id.nav_view)

        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.civilizationFragment,
            R.id.foodFragment,
            R.id.splashFragment

        ), layoutDrawer)

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


}