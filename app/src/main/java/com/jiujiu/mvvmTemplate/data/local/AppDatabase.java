package com.jiujiu.mvvmTemplate.data.local;

import com.jiujiu.mvvmTemplate.data.local.dao.ProductDao;
import com.jiujiu.mvvmTemplate.data.model.Product;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = Product.class, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProductDao productDao();
}
