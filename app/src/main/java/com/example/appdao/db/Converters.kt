package com.example.appdao.db

import androidx.room.TypeConverter
import java.util.Date

class Converters {

    @TypeConverter
    fun FromTimeStamp ( value: Long?): Date?{
        return value?.let {Date(it)}
    }

    @TypeConverter
    fun dateToTimestamp (date: Date?): Long?{
        return date?.time?.toLong()
    }
}