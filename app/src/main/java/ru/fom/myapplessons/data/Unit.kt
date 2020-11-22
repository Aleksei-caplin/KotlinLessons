package ru.fom.myapplessons.data

data class UnitList(
    val units: List<Unit> = listOf()
)

data class Unit(
    val id: Int = 0,
    val name: String = "",
    val description: String = "",
    val expansion: String = "",
    val age: String = "",
    val created_in: String = "",
    val build_time: String = "",
    val attack_delay: String = ""
)