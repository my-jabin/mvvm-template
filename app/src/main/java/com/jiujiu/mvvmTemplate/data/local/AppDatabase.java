package com.jiujiu.mvvmTemplate.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.jiujiu.mvvmTemplate.data.local.dao.UserDao;
import com.jiujiu.mvvmTemplate.data.model.User;

@Database(entities = User.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
