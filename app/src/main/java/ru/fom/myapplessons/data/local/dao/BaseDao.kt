package ru.fom.myapplessons.data.local.dao

import androidx.room.*

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

    @Delete
    fun delete(obj: T)
}