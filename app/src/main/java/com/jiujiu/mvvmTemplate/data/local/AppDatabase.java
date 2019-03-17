package com.jiujiu.mvvmTemplate.data.local;

import com.jiujiu.mvvmTemplate.data.local.dao.UserDao;
import com.jiujiu.mvvmTemplate.data.model.User;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = User.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
