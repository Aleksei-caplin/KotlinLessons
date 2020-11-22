package ru.fom.myapplessons.data

data class StructureList(
    val structures: List<Structure> = listOf()
)

data class Structure(
    val id:Int = 0,
    val name: String = "",
    val description: String = "",
    val expansion: String = "",
    val age: String = "",
    val build_time: String = ""
)