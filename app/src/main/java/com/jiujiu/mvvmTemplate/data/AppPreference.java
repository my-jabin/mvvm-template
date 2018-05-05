package com.jiujiu.mvvmTemplate.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.jiujiu.mvvmTemplate.di.PreferenceInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppPreference {

    private static final String PREF_KEY_USER_NAME = "prefs_username";

    private final SharedPreferences mPreference;

    @Inject
    public AppPreference(Context context, @PreferenceInfo String preInfo) {
        mPreference = context.getSharedPreferences(preInfo, Context.MODE_PRIVATE);
    }

    public void setUserName(String userName) {
        mPreference.edit().putString(PREF_KEY_USER_NAME, userName).apply();
    }

    public String getUserName() {
        return mPreference.getString(PREF_KEY_USER_NAME, null);
    }

}
