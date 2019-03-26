package com.jiujiu.mvvmTemplate.ui.products;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.jiujiu.mvvmTemplate.BR;
import com.jiujiu.mvvmTemplate.R;
import com.jiujiu.mvvmTemplate.databinding.FragmentProductsBinding;
import com.jiujiu.mvvmTemplate.ui.base.BaseFragment;


public class ProductsFragment extends BaseFragment<FragmentProductsBinding, ProductsFragViewModel> {
    private static final String TAG = "ProductsFragment";
    private static ProductsFragment mFragment;

    private ProductsRecyclerAdapter mAdapter;

    public ProductsFragment() {
        Log.d(TAG, "ProductsFragment: constructors");
    }

    public static ProductsFragment getInstance() {
        if (mFragment == null) {
            mFragment = new ProductsFragment();
        }
        return mFragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupLayout();
        setupViewModel();
        Log.d(TAG, "onViewCreated: ");
    }

    private void setupLayout() {
        mAdapter = new ProductsRecyclerAdapter();
        getBinding().rvProducts.setAdapter(mAdapter);
        getBinding().rvProducts.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener() {
        });
    }

    private void setupViewModel() {
        getViewModel().getProductLiveData().observe(this, products -> this.mAdapter.setmData(products));
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
    protected Class<ProductsFragViewModel> getViewModelType() {
        return ProductsFragViewModel.class;
    }

}
