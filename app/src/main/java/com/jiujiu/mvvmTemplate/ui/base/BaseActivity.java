package com.jiujiu.mvvmTemplate.ui.base;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import dagger.android.AndroidInjection;

public abstract class BaseActivity<T extends ViewDataBinding, V extends ViewModel> extends AppCompatActivity {

    private T mBinding;
    private V viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        performDenpendencyInjection();
        super.onCreate(savedInstanceState);
        performDataBinding();
    }

    @LayoutRes
    public abstract int getLayoutId();

    public abstract V getViewModel();

    public void performDataBinding() {
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());
        viewModel = viewModel == null ? getViewModel() : viewModel;
        mBinding.setVariable(getBindingVariableId(), viewModel);
        mBinding.executePendingBindings();
    }


    public void performDenpendencyInjection() {
        AndroidInjection.inject(this);
    }

    public abstract int getBindingVariableId();

    public T getBinding() {
        return mBinding;
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }
}
