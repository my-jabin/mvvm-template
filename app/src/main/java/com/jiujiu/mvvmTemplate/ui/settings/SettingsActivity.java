package com.jiujiu.mvvmTemplate.ui.settings;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.databinding.library.baseAdapters.BR;
import com.jiujiu.mvvmTemplate.R;
import com.jiujiu.mvvmTemplate.databinding.ActivitySplashBinding;
import com.jiujiu.mvvmTemplate.ui.base.BaseActivity;
import com.jiujiu.mvvmTemplate.util.AppConstant;

import javax.inject.Inject;

public class SettingsActivity extends BaseActivity<ActivitySplashBinding, SettingsActivityViewModel> {

    @Inject
    ViewModelProvider.Factory factory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getViewModel().setNavigator(this);
        getViewModel().setCurrentUserName(AppConstant.USERNAME);
//        getViewModel().startSeeding();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_settings;
    }

    @Override
    public SettingsActivityViewModel generateViewModel() {
        return ViewModelProviders.of(this, factory).get(SettingsActivityViewModel.class);
    }

    @Override
    public int getBindingVariableId() {
        return BR.viewModel;
    }


//    @Override
//    public void openMainActivity() {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//        finish();
//    }
}
