package com.jiujiu.mvvmTemplate.ui.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.jiujiu.mvvmTemplate.ui.customers.CustomersFragment;
import com.jiujiu.mvvmTemplate.ui.orders.OrdersFragment;
import com.jiujiu.mvvmTemplate.ui.products.ProductsFragment;

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    public MainViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ProductsFragment.getInstance();
            case 1:
                return OrdersFragment.getInstance();
            case 2:
                return CustomersFragment.getInstance();
            default:
                throw new IllegalArgumentException("Error fragment in viewpager");
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
