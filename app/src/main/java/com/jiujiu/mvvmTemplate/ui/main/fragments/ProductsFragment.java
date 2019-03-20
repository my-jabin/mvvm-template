package com.jiujiu.mvvmTemplate.ui.main.fragments;

import android.os.Bundle;
import android.view.View;

import com.jiujiu.mvvmTemplate.BR;
import com.jiujiu.mvvmTemplate.R;
import com.jiujiu.mvvmTemplate.databinding.FragmentProductsBinding;
import com.jiujiu.mvvmTemplate.ui.base.BaseFragment;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;


public class ProductsFragment extends BaseFragment<FragmentProductsBinding, ProductsFragViewModel> {
    private static final String TAG = "ProductsFragment";
    private static ProductsFragment mFragment;

    @Inject
    ViewModelProvider.Factory factory;

    public static ProductsFragment getInstance() {
        if (mFragment == null) {
            mFragment = new ProductsFragment();
        }
        return mFragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        setupViewModel();

        getViewModel().loadProducts();
    }

    private void setupViewModel() {
        getViewModel().getProductLiveData().observe(this, products -> {
            if (products == null) return;
            getBinding().tvMain.setText("Total products: " + products.size());
        });
    }

    @Override
    protected int getBindingVariableId() {
        return BR.viewModel;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_products;
    }

    @Override
    protected ProductsFragViewModel generateViewmodel() {
        return ViewModelProviders.of(this, factory).get(ProductsFragViewModel.class);
    }


}
