package com.jiujiu.mvvmTemplate.ui.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.DaggerFragment;

public abstract class BaseFragment<T extends ViewDataBinding, V extends BaseViewModel> extends DaggerFragment {

    @Inject
    ViewModelProvider.Factory factory;

    private T mBinding;
    private V mViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = generateViewmodel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        mBinding.setLifecycleOwner(this);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.setVariable(getBindingVariableId(), mViewModel);
        mBinding.executePendingBindings();
    }

    protected abstract int getBindingVariableId();

    @LayoutRes
    protected abstract int getLayoutId();

    private V generateViewmodel() {
        return ViewModelProviders.of(this, factory).get(getViewModelType());
    }

    protected abstract Class<V> getViewModelType();


    public T getBinding() {
        return mBinding;
    }

    public V getViewModel() {
        return mViewModel;
    }
}
