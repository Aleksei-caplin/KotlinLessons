package ru.fom.myapplessons.data.local

import androidx.room.TypeConverter
import java.util.*

class DateConverter{
    @TypeConverter
    fun timestampToDate(timestamp: Long): Date = Date(timestamp)

    @TypeConverter
    fun dateToTimesatmp(date: Date): Long  = date.time
}