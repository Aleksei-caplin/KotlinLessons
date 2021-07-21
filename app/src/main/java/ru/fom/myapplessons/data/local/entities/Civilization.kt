package ru.fom.myapplessons.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "civilizations")
data class Civilization(
    @PrimaryKey()
    val id: String,
    val name: String,
    val expansion: String,
    val army_type: String,
    val team_bonus: String,
    @Embedded(prefix = "warrior_")
    val unique_unit: Warrior,
)

data class Warrior(
    val id: String,
    val name: String,
    val description: String,
    val expansion: String,
    val age: String,
    @Embedded(prefix = "cost_")
    val cost: Cost,
)

data class Cost(
    val food: Int?,
    val gold: Int?,
    val stone: Int?,
    val meet: Int?,
)