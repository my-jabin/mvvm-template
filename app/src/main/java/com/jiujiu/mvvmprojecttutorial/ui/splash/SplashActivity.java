package com.jiujiu.mvvmprojecttutorial.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.databinding.library.baseAdapters.BR;
import com.jiujiu.mvvmprojecttutorial.R;
import com.jiujiu.mvvmprojecttutorial.databinding.ActivitySplashBinding;
import com.jiujiu.mvvmprojecttutorial.ui.base.BaseActivity;
import com.jiujiu.mvvmprojecttutorial.ui.main.MainActivity;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity<ActivitySplashBinding,SplashActivityViewModel> implements SplashNavigator{

    @Inject
    SplashActivityViewModel mViewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
        mViewModel.startSeeding();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public SplashActivityViewModel getViewModel() {
        return mViewModel;
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
