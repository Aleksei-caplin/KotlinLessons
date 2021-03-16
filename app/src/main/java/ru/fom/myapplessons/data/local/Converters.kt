package ru.fom.myapplessons.data.local

import androidx.room.TypeConverter
import java.util.*

class DateConverters {
    @TypeConverter
    fun timestampToDate(timestamp: Long): Date = Date(timestamp)

    @TypeConverter
    fun dateToTimestamp(date: Date): Long = date.time
}