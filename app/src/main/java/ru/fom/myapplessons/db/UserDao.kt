package ru.fom.myapplessons.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.fom.myapplessons.data.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table")
    suspend fun getAll(): List<User>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun userAdd (vararg user: User)
}