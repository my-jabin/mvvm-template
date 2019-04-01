package com.jiujiu.mvvmTemplate.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

import com.jiujiu.mvvmTemplate.data.local.dao.ProductDao
import com.jiujiu.mvvmTemplate.data.model.Converters
import com.jiujiu.mvvmTemplate.data.model.Product

@Database(entities = [Product::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}
