package ru.fom.myapplessons.data

import kotlinx.serialization.Serializable

data class CivilizationList(
    val civilizations: List<Civilization> = listOf()
)

@Serializable
data class Civilization (
    val id: Int = 0,
    val name: String = "",
    val expansion: String = "",
    val army_type: String = ""
)