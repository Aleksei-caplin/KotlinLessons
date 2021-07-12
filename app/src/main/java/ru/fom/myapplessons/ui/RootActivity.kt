package ru.fom.myapplessons.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.fom.myapplessons.R
import ru.fom.myapplessons.data.local.DbManager
import ru.fom.myapplessons.data.local.DbManager.db
import ru.fom.myapplessons.data.local.entities.Article

class RootActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            val expectedArticle = Article(
                "0",
                "test_article",
                "test description",
                "0",
                "any"
            )

            db.articlesDao().insert(expectedArticle)

        }
    }
}