package ru.fom.myapplessons.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import ru.fom.myapplessons.data.local.entities.Civilization

@Dao
interface CivilizationDao: BaseDao<Civilization> {

    @Transaction
    fun upsert(list: List<Civilization>) {
        insert(list)
            .mapIndexed { index, recordResult -> if(recordResult == -1L) list[index] else null }
            .firstOrNull()
            .also { if(it.toString().isNotEmpty()) it?.let { it1 -> update(it1) } }
    }

    @Query(""" SELECT * FROM civilization """)
    fun findCivilizations(): List<Civilization>

    @Query(""" SELECT * FROM civilization WHERE id = :id """)
    fun findCivById(id: String): Civilization
}