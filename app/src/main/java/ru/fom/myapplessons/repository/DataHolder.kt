package ru.fom.myapplessons.repository

import android.util.Log
import ru.fom.myapplessons.data.Sections

object DataHolder {
    private val sectionTitles = listOf(
        "Цивилизации",
        "Здания",
        "Технологии",
        "Войска"
    )
    private val sectionsCode = listOf(
        "civilization_list",
        "building_list",
        "tehnology_list",
        "army_list"
    )

    fun staticSections(): List<Sections> {
        val list = mutableListOf<Sections>()
        for (i in sectionTitles.indices) {
            list.add(
                Sections(i, sectionTitles[i], 0, sectionsCode[i])
            )
        }
        return list
    }
}