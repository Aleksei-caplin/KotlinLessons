package ru.fom.myapplessons.utils

import androidx.fragment.app.Fragment
import ru.fom.myapplessons.MainActivity

// constants
lateinit var APP_ACTIVITY: MainActivity


// functions
fun replaceFragment(container: Int, fragment: Fragment) {
    APP_ACTIVITY.supportFragmentManager.beginTransaction()
        .replace(container, fragment)
        .commit()
}