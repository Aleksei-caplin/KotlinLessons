package ru.fom.myapplessons.data

data class CivilizationList(
    val civilizations: List<Civilization> = listOf()
)

data class Civilization (
    val id: Int = 0,
    val name: String = "",
    val expansion: String = "",
    val army_type: String = ""
)