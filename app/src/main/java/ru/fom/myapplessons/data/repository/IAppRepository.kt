package ru.fom.myapplessons.data.repository

import ru.fom.myapplessons.data.local.entities.Civilization

interface IAppRepository {
    suspend fun getCivilisations(): Int
    suspend fun insertCivilizationsToDb(civilizations: List<Civilization>)
}