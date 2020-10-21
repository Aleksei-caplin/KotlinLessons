package ru.fom.myapplessons.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.fom.myapplessons.data.User.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String = "",
    val age: Int = 0
) {
    companion object {
        const  val  TABLE_NAME  =  "user_table"
    }
}