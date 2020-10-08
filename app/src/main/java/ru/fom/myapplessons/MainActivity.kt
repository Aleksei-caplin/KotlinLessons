package ru.fom.myapplessons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.fom.myapplessons.ui.fragments.CivilizationsListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.supportFragmentManager.beginTransaction()
            .replace(R.id.wrap_content, CivilizationsListFragment() )
            .commit()
    }
}