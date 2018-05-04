package com.jiujiu.mvvmprojecttutorial.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.jiujiu.mvvmprojecttutorial.data.local.dao.UserDao;
import com.jiujiu.mvvmprojecttutorial.data.model.User;

@Database(entities = User.class,version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
