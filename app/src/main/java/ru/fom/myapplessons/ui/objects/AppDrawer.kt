package ru.fom.myapplessons.ui.objects

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem
import ru.fom.myapplessons.R
import ru.fom.myapplessons.utils.APP_ACTIVITY


class AppDrawer(
        private val navController: NavController,
        private val toolbar: Toolbar
) {

    private lateinit var drawer: Drawer
    private lateinit var header: AccountHeader


    fun createSideMenu() {
        createHeader()
        createDrawer()
    }

    private fun createDrawer() {
        drawer = DrawerBuilder()
            .withActivity(APP_ACTIVITY)
            .withToolbar(toolbar)
            .withActionBarDrawerToggle(true)
            .withSelectedItem(-1)
            //.withAccountHeader(header)
            .addDrawerItems(
                    PrimaryDrawerItem().withIdentifier(100)
                            .withIconTintingEnabled(true)
                            .withName("Цивилизации")
                            .withSelectable(false)
                            .withIcon(R.drawable.ic_launcher_foreground),

                    PrimaryDrawerItem().withIdentifier(105)
                            .withIconTintingEnabled(true)
                            .withName(" - Фильтр по названию")
                            .withSelectable(false)
                            .withLevel(5),
                    PrimaryDrawerItem().withIdentifier(101)
                            .withIconTintingEnabled(true)
                            .withName("Здания")
                            .withSelectable(false)
                            .withIcon(R.drawable.ic_launcher_foreground),
                    PrimaryDrawerItem().withIdentifier(102)
                            .withIconTintingEnabled(true)
                            .withName("Технологии")
                            .withSelectable(false)
                            .withIcon(R.drawable.ic_launcher_foreground),
                    PrimaryDrawerItem().withIdentifier(103)
                            .withIconTintingEnabled(true)
                            .withName("Войска")
                            .withSelectable(false)
                            .withIcon(R.drawable.ic_launcher_foreground)
            )
            .withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                override fun onItemClick(
                        view: View?,
                        position: Int,
                        drawerItem: IDrawerItem<*>
                ): Boolean {
                    clickToItem(position)
                    return false
                }
            })
            .build()
    }

    fun clickToItem(position: Int) {
        when(position) {
            0 -> navController.navigate(R.id.civilizationsListFragment2)
            1 -> {
                val bundle = Bundle()
                bundle.putString("filter", "Age of Kings")
                navController.navigate(R.id.civilizationsListFragment2, bundle)
            }
            2 -> navController.navigate(R.id.structureListFragment)
            3 -> navController.navigate(R.id.tehnologyFragment)
            4 -> navController.navigate(R.id.armyFragment)
        }
    }

    private fun createHeader() {
        header = AccountHeaderBuilder()
            .withActivity(APP_ACTIVITY)
            .withHeaderBackground(R.color.md_dark_background)
            //.withAccountHeader(R.layout.drawer_header)
            .build()
    }
}