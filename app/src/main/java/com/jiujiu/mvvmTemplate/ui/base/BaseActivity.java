package com.jiujiu.mvvmTemplate.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import javax.inject.Inject;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

//public abstract class BaseActivity<T extends ViewDataBinding, V extends ViewModel> extends AppCompatActivity implements HasSupportFragmentInjector {
public abstract class BaseActivity<T extends ViewDataBinding, V extends ViewModel> extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    ViewModelProvider.Factory factory;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    private T mBinding;
    private V viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        performDenpendencyInjection();
        super.onCreate(savedInstanceState);
        performViewModel();
        performDataBinding();
    }

    private void performViewModel() {
        viewModel = ViewModelProviders.of(this, factory).get(getViewModelClassType());
    }

    //    protected abstract V generateViewModel();
    protected abstract Class<V> getViewModelClassType();

    @LayoutRes
    public abstract int getLayoutId();

    public V getViewModel() {
        return viewModel;
    }

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

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
