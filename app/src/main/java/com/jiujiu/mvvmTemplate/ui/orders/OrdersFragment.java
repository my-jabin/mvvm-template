package com.jiujiu.mvvmTemplate.ui.orders;


import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.jiujiu.mvvmTemplate.BR;
import com.jiujiu.mvvmTemplate.R;
import com.jiujiu.mvvmTemplate.databinding.FragmentOrdersBinding;
import com.jiujiu.mvvmTemplate.ui.base.BaseFragment;


public class OrdersFragment extends BaseFragment<FragmentOrdersBinding, OrdersFragViewModel> {
    private static final String TAG = "OrdersFragment";
    private static OrdersFragment mFragment;

    public OrdersFragment() {
        Log.d(TAG, "OrdersFragment: constructors");
    }

    public static OrdersFragment getInstance() {
        if (mFragment == null) {
            mFragment = new OrdersFragment();
        }
        return mFragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupViewModel();
        Log.d(TAG, "onViewCreated: ");
    }

    private void setupViewModel() {
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
    protected Class<OrdersFragViewModel> getViewModelType() {
        return OrdersFragViewModel.class;
    }

}
