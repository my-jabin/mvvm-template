package com.jiujiu.mvvmTemplate;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.Configuration;
import androidx.work.WorkManager;
import androidx.work.WorkerFactory;

import com.jiujiu.mvvmTemplate.data.local.AppDatabase;
import com.jiujiu.mvvmTemplate.di.component.DaggerAppComponent;

import java.lang.reflect.Method;
import java.util.HashMap;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class MvvmApp extends DaggerApplication {

    @Inject
    WorkerFactory myWorkerFactory;

    @Inject
    AppDatabase mDatabase;

    @Override
    public void onCreate() {
        super.onCreate();

        WorkManager.initialize(this, new Configuration.Builder().setWorkerFactory(myWorkerFactory).build());

        setInMemoryRoomDatabases(mDatabase.getOpenHelper().getWritableDatabase());

    }

    @Override
    protected AndroidInjector<? extends MvvmApp> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }

    // for in memory database debugging
    public static void setInMemoryRoomDatabases(SupportSQLiteDatabase... database) {
        if (BuildConfig.DEBUG) {
            try {
                Class<?> debugDB = Class.forName("com.amitshekhar.DebugDB");
                Class[] argTypes = new Class[]{HashMap.class};
                HashMap<String, SupportSQLiteDatabase> inMemoryDatabases = new HashMap<>();
                // set your inMemory databases
                inMemoryDatabases.put("InMemoryOne.db", database[0]);
                Method setRoomInMemoryDatabase = debugDB.getMethod("setInMemoryRoomDatabases", argTypes);
                setRoomInMemoryDatabase.invoke(null, inMemoryDatabases);
            } catch (Exception ignore) {

            }
        }
    }
}
