package com.jiujiu.mvvmTemplate.data;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DataManager {

    private AppPreference mPreference;

    @Inject
    public DataManager(AppPreference preference) {
        mPreference = preference;
    }

    public String getCurrentUserName() {
        return this.mPreference.getUserName();
    }

    public void setCurrentUserName(String userName) {
        this.mPreference.setUserName(userName);
    }
}
