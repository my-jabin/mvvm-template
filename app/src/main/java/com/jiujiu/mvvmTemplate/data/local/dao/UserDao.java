package com.jiujiu.mvvmTemplate.data.local.dao;

import com.jiujiu.mvvmTemplate.data.model.User;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
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
