package com.jiujiu.mvvmTemplate.data;

import com.jiujiu.mvvmTemplate.data.repository.UserRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DataManager {

    private AppPreference mPreference;
    private UserRepository mUserRepository;

    @Inject
    public DataManager(AppPreference preference, UserRepository userRepository) {
        mPreference = preference;
        this.mUserRepository = userRepository;
    }

    public String getCurrentUserName() {
        return this.mPreference.getUserName();
    }

    public void setCurrentUserName(String userName) {
        this.mPreference.setUserName(userName);
    }
}
