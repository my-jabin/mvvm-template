package com.jiujiu.mvvmTemplate.ui.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import dagger.android.support.AndroidSupportInjection;

public abstract class BaseFragment<T extends ViewDataBinding, V extends BaseViewModel> extends Fragment {

    private T mBinding;
    private V mViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        performDenpendencyInjection();
        super.onCreate(savedInstanceState);
        mViewModel = generateViewmodel();
    }

    private void performDenpendencyInjection() {
        AndroidSupportInjection.inject(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
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

    protected abstract V generateViewmodel();

    public T getBinding() {
        return mBinding;
    }

    public V getViewModel() {
        return mViewModel;
    }
}
