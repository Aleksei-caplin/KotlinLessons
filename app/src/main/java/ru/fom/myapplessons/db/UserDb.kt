package ru.fom.myapplessons.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.fom.myapplessons.data.User

@Database(entities = [User::class], version = 1)
abstract class UserDb: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private var db_instance: UserDb? = null

        fun getDataBase(context: Context): UserDb {
            if(db_instance == null) {
                synchronized(UserDb::class.java) {
                    if(db_instance == null) {
                        db_instance = Room.databaseBuilder(context.applicationContext, UserDb::class.java, "user_db")
                            .addCallback(object: Callback(){

                            })
                            .build()
                    }
                }
            }
            return db_instance!!
        }
    }
}