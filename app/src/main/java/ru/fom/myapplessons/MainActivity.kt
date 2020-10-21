package ru.fom.myapplessons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.fom.myapplessons.data.User
import ru.fom.myapplessons.db.UserDao
import ru.fom.myapplessons.db.UserDb


class MainActivity : AppCompatActivity() {

    lateinit var user_db: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        user_db = UserDb.getDataBase(application).userDao()

        GlobalScope.launch(Dispatchers.IO) {
            user_db.userAdd(User(0, "Василий", 23))
        }
    }
}