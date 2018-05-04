package com.jiujiu.mvvmprojecttutorial.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.jiujiu.mvvmprojecttutorial.data.model.User;

import javax.inject.Singleton;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;


@Dao
public interface UserDao {

    @Query("select * from user where id = :id")
    Maybe<User> getUserById(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

    @Delete
    void deleteUser(User user);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateUser(User user);
}
