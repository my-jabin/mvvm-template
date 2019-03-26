package com.jiujiu.mvvmTemplate.ui.customers;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.jiujiu.mvvmTemplate.BR;
import com.jiujiu.mvvmTemplate.R;
import com.jiujiu.mvvmTemplate.databinding.FragmentCustomersBinding;
import com.jiujiu.mvvmTemplate.ui.base.BaseFragment;


public class CustomersFragment extends BaseFragment<FragmentCustomersBinding, CustomersFragViewModel> {
    private static final String TAG = "CustomersFragment";
    private static CustomersFragment mFragment;

    public CustomersFragment() {
        Log.d(TAG, "CustomersFragment: constructors");
    }

    public static CustomersFragment getInstance() {
        if (mFragment == null) {
            mFragment = new CustomersFragment();
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
        return R.layout.fragment_customers;
    }

    @Override
    protected Class<CustomersFragViewModel> getViewModelType() {
        return CustomersFragViewModel.class;
    }

}
