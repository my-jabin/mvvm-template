package com.jiujiu.mvvmTemplate.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.jiujiu.mvvmTemplate.data.local.dao.ProductDao;
import com.jiujiu.mvvmTemplate.data.model.Product;

@Database(entities = Product.class, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProductDao productDao();
}
