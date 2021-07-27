package ru.fom.myapplessons.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "app_settings")
data class SettingsEntity(
    @PrimaryKey
    val id: String,
    val token: String,
    val updatedAt: Long
)