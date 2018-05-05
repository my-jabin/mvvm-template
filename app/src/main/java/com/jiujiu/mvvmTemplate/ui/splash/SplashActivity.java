package com.jiujiu.mvvmTemplate.ui.splash;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.databinding.library.baseAdapters.BR;
import com.jiujiu.mvvmTemplate.R;
import com.jiujiu.mvvmTemplate.databinding.ActivitySplashBinding;
import com.jiujiu.mvvmTemplate.ui.base.BaseActivity;
import com.jiujiu.mvvmTemplate.ui.main.MainActivity;
import com.jiujiu.mvvmTemplate.util.AppConstant;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashActivityViewModel> implements SplashNavigator {

    @Inject
    ViewModelProvider.Factory factory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getViewModel().setNavigator(this);
        getViewModel().setCurrentUserName(AppConstant.USERNAME);
        getViewModel().startSeeding();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public SplashActivityViewModel generateViewModel() {
        return ViewModelProviders.of(this, factory).get(SplashActivityViewModel.class);
    }

    @Override
    public int getBindingVariableId() {
        return BR.viewModel;
    }


    @Override
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
