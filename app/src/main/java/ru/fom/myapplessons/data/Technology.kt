package ru.fom.myapplessons.data

data class TechnologyList(
    val technologies: List<Technology> = listOf()
)

data class Technology(
    val id: Int = 0,
    val name: String = "",
    val description: String = "",
    val expansion: String = "",
    val age: String = "",
    val develops_in: String = "",
    val build_time: String = ""
)