package com.jiujiu.mvvmTemplate.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.jiujiu.mvvmTemplate.data.model.User;

import io.reactivex.Maybe;


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
