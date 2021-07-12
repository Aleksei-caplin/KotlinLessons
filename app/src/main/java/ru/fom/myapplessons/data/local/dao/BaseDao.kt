package ru.fom.myapplessons.data.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import androidx.room.Update

interface BaseDao<T: Any> {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(list:List<T>): List<Long>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(obj:T): Long

    @Update
    fun update(list:List<T>)

    @Update
    fun update(obj:T)
}