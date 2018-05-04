package com.jiujiu.mvvmTemplate.data.repository;

import com.jiujiu.mvvmTemplate.data.local.dao.UserDao;

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
