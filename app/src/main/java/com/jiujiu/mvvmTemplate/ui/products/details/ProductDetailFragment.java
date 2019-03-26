package com.jiujiu.mvvmTemplate.ui.products.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.jiujiu.mvvmTemplate.BR;
import com.jiujiu.mvvmTemplate.R;
import com.jiujiu.mvvmTemplate.databinding.ProductDetailBinding;
import com.jiujiu.mvvmTemplate.ui.base.BaseFragment;

public class ProductDetailFragment extends BaseFragment<ProductDetailBinding, ProductDetailViewModel> {

    private static final String TAG = "ProductDetailFragment";
    private Long productId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);
        setHasOptionsMenu(true);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        productId = ProductDetailFragmentArgs.fromBundle(getArguments()).getProductId();
        getViewModel().loadProductById(productId);
        setupViewModel();
    }

    private void setupViewModel() {
    }

    @Override
    public void onPrepareOptionsMenu(@NonNull Menu menu) {
        // dynamically change option menu
        menu.findItem(R.id.menu_settings).setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected int getBindingVariableId() {
        return BR.viewModel;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.product_detail;
    }

    @Override
    protected Class<ProductDetailViewModel> getViewModelType() {
        return ProductDetailViewModel.class;
    }
}
