package ru.fom.myapplessons.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ru.fom.myapplessons.data.local.entities.Civilization

@Dao
interface CivilizationDao: BaseDao<Civilization> {

    // выборка всех записей из таблицы
    @Query("""
        SELECT * FROM civilizations
    """)
    fun findCivilizations(): List<Civilization>

    // добавление одной записи в таблицу
    @Insert
    fun addCivilization(vararg civilization: Civilization)

    // добавление списка записей
    fun upsert(list: List<Civilization>) {
        insert(list)
            .mapIndexed { index, recordResult -> if(recordResult == -1L) list[index] else null}
            .filterNotNull()
            .also { if(it.isNotEmpty()) update(it) }
    }

    // удаление записи
    @Delete
    fun deleteItem(vararg civilization: Civilization)


}