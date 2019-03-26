package com.jiujiu.mvvmTemplate.di.module;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.jiujiu.mvvmTemplate.data.local.AppDatabase;
import com.jiujiu.mvvmTemplate.data.local.dao.ProductDao;
import com.jiujiu.mvvmTemplate.di.scope.DatabaseInfo;
import com.jiujiu.mvvmTemplate.di.scope.PreferenceInfo;
import com.jiujiu.mvvmTemplate.util.AppConstant;
import com.jiujiu.mvvmTemplate.worker.PrePopulateDataWorker;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ViewModelModule.class, WorkerBindingModule.class})
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
//        return Room.databaseBuilder(context, AppDatabase.class, databaseName).addCallback(
        // in memory database
        return Room.inMemoryDatabaseBuilder(context, AppDatabase.class).addCallback(
                new RoomDatabase.Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(PrePopulateDataWorker.class).build();
                        WorkManager.getInstance().enqueue(request);
                    }
                }
        ).build();
    }

    @Provides
    @Singleton
    ProductDao provideProductDao(AppDatabase database) {
        return database.productDao();
    }


}
