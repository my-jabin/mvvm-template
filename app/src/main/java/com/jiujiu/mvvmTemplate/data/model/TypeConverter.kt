package com.jiujiu.mvvmTemplate.data.model

import androidx.room.TypeConverter
import java.util.*

class Converters {
    @TypeConverter
    fun fromCalenderToLong(calendar: Calendar) = calendar.timeInMillis

    @TypeConverter
    fun fromLongToCalender(time: Long) : Calendar = Calendar.getInstance().apply { timeInMillis = time }
}