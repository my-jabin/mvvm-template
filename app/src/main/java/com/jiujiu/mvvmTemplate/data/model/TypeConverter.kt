package com.jiujiu.mvvmTemplate.data.model

import androidx.room.TypeConverter
import java.util.*

class Converters {
    @TypeConverter
    fun fromCalenderToLong(calender: Calendar) = calender.timeInMillis

    @TypeConverter
    fun fromLongToCalender(time: Long) = Calendar.getInstance().apply { timeInMillis = time }
}