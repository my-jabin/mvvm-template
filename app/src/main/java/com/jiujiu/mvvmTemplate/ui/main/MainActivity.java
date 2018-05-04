package com.jiujiu.mvvmTemplate.ui.main;

import android.os.Bundle;

import com.jiujiu.mvvmTemplate.BR;
import com.jiujiu.mvvmTemplate.R;
import com.jiujiu.mvvmTemplate.databinding.ActivityMainBinding;
import com.jiujiu.mvvmTemplate.ui.base.BaseActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<ActivityMainBinding,MainActivityViewModel> {

    @Inject
    MainActivityViewModel mViewModel;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainActivityViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public int getBindingVariableId() {
        return BR.viewModel;
    }
}
