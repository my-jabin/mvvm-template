package com.jiujiu.mvvmTemplate.ui.settings;

import android.os.Bundle;

import com.jiujiu.mvvmTemplate.BR;
import com.jiujiu.mvvmTemplate.R;
import com.jiujiu.mvvmTemplate.databinding.ActivitySettingsBinding;
import com.jiujiu.mvvmTemplate.ui.base.BaseActivity;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

public class SettingsActivity extends BaseActivity<ActivitySettingsBinding, SettingsActivityViewModel> {

    // todo: create a simple settings activity

    @Inject
    ViewModelProvider.Factory factory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

}
