package com.jiujiu.mvvmprojecttutorial.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.jiujiu.mvvmprojecttutorial.data.local.AppDatabase;
import com.jiujiu.mvvmprojecttutorial.data.local.dao.UserDao;
import com.jiujiu.mvvmprojecttutorial.data.repository.UserRepository;
import com.jiujiu.mvvmprojecttutorial.di.DatabaseInfo;
import com.jiujiu.mvvmprojecttutorial.util.AppConstant;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = ViewModelModule.class)
public class AppModule {

    @Provides
    @DatabaseInfo
    String provideDatabaseName(){
        return AppConstant.DATABASENAME;
    }

    @Provides
    @Singleton
    Context provideContext(Application application){
        return application;
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(Context context, @DatabaseInfo String databaseName){
        return Room.databaseBuilder(context,AppDatabase.class,databaseName).build();
    }

    @Provides
    @Singleton
    UserDao provideUserDao(AppDatabase database){
        return database.userDao();
    }

}
