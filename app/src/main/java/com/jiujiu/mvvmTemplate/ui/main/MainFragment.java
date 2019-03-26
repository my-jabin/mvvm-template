package com.jiujiu.mvvmTemplate.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.databinding.library.baseAdapters.BR;
import androidx.viewpager.widget.ViewPager;

import com.jiujiu.mvvmTemplate.R;
import com.jiujiu.mvvmTemplate.databinding.FragmentMainBinding;
import com.jiujiu.mvvmTemplate.ui.base.BaseFragment;

public class MainFragment extends BaseFragment<FragmentMainBinding, MainFragViewModel> {

    private static final String TAG = "MainFragment";

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupLayout();
        Log.d(TAG, "onViewCreated: ");
    }

    private void setupLayout() {
        // set up vier pager
        // nested fragment, using getChildFragmentManager() to obtain fragment manager
        getBinding().viewPager.setAdapter(new MainViewPagerAdapter(getChildFragmentManager()));
        getBinding().viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                int itemId = getBinding().bottomNavigation.getMenu().getItem(position).getItemId();
                getBinding().bottomNavigation.setSelectedItemId(itemId);
            }
        });

        // setup bottom navigation view
        getBinding().bottomNavigation.setOnNavigationItemSelectedListener(item -> {
            showFragment(item.getItemId());
            return true;
        });
    }

    private void showFragment(@IdRes int itemId) {
        switch (itemId) {
            case R.id.bottom_navi_order:
                getBinding().viewPager.setCurrentItem(1, true);
                break;
            case R.id.bottom_navi_customer:
                getBinding().viewPager.setCurrentItem(2, true);
                break;
            default: // R.id.bottom_navi_product:
                getBinding().viewPager.setCurrentItem(0, true);
                break;
        }
    }

    @Override
    protected int getBindingVariableId() {
        return BR.viewModel;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected Class<MainFragViewModel> getViewModelType() {
        return MainFragViewModel.class;
    }


}
