package com.jiujiu.mvvmTemplate.ui.main;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.widget.TextView;

import com.jiujiu.mvvmTemplate.BR;
import com.jiujiu.mvvmTemplate.R;
import com.jiujiu.mvvmTemplate.databinding.ActivityMainBinding;
import com.jiujiu.mvvmTemplate.ui.base.BaseActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainActivityViewModel> {

    @Inject
    ViewModelProvider.Factory factory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView textView = findViewById(R.id.textView);
        String userName = getViewModel().getCurrentUserName();
        textView.setText(userName);
    }

    @Override
    protected MainActivityViewModel generateViewModel() {
        return ViewModelProviders.of(this, factory).get(MainActivityViewModel.class);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public int getBindingVariableId() {
        return BR.viewModel;
    }
}
