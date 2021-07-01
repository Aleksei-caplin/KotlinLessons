package ru.fom.myapplessons.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.fom.myapplessons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}