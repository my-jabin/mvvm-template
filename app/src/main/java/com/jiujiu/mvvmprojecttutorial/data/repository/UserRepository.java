package com.jiujiu.mvvmprojecttutorial.data.repository;

import com.jiujiu.mvvmprojecttutorial.data.local.dao.UserDao;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserRepository {

    private UserDao userDao;

    @Inject
    public UserRepository(UserDao userDao) {
        this.userDao = userDao;
    }
}
