package com.jiujiu.mvvmprojecttutorial.ui.main;

import android.arch.lifecycle.ViewModel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jiujiu.mvvmprojecttutorial.BR;
import com.jiujiu.mvvmprojecttutorial.R;
import com.jiujiu.mvvmprojecttutorial.databinding.ActivityMainBinding;
import com.jiujiu.mvvmprojecttutorial.ui.base.BaseActivity;

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
