package com.jiujiu.mvvmTemplate.di.module;

import android.app.Application;
import android.content.Context;

import com.jiujiu.mvvmTemplate.data.local.AppDatabase;
import com.jiujiu.mvvmTemplate.data.local.dao.UserDao;
import com.jiujiu.mvvmTemplate.di.DatabaseInfo;
import com.jiujiu.mvvmTemplate.di.PreferenceInfo;
import com.jiujiu.mvvmTemplate.util.AppConstant;

import javax.inject.Singleton;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;

@Module(includes = ViewModelModule.class)
public class AppModule {

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstant.DATABASENAME;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstant.PREFERENCENAME;
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(Context context, @DatabaseInfo String databaseName) {
        return Room.databaseBuilder(context, AppDatabase.class, databaseName).build();
    }

    @Provides
    @Singleton
    UserDao provideUserDao(AppDatabase database) {
        return database.userDao();
    }


}
