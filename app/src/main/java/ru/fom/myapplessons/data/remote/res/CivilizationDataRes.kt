package ru.fom.myapplessons.data.remote.res

data class CivilizationList(
    val civilizations : List<CivilizationDataRes>
)

data class CivilizationDataRes (
    val id: String,
    val name: String,
    val expansion: String,
    val army_type: String,
    val team_bonus: String,
)

