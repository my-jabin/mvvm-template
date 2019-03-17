package com.jiujiu.mvvmTemplate.ui.main.fragments;


import android.os.Bundle;
import android.view.View;

import com.jiujiu.mvvmTemplate.BR;
import com.jiujiu.mvvmTemplate.R;
import com.jiujiu.mvvmTemplate.databinding.FragmentOrdersBinding;
import com.jiujiu.mvvmTemplate.ui.base.BaseFragment;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;


public class OrdersFragment extends BaseFragment<FragmentOrdersBinding, OrdersFragViewModel> {

    private static OrdersFragment mFragment;

    @Inject
    ViewModelProvider.Factory factory;

    public static OrdersFragment getInstance() {
        if (mFragment == null) {
            mFragment = new OrdersFragment();
        }
        return mFragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected int getBindingVariableId() {
        return BR.viewModel;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_orders;
    }

    @Override
    protected OrdersFragViewModel generateViewmodel() {
        return ViewModelProviders.of(this, factory).get(OrdersFragViewModel.class);
    }
}
