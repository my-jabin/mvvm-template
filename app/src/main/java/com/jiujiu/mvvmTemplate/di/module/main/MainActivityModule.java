package com.jiujiu.mvvmTemplate.di.module.main;

import com.jiujiu.mvvmTemplate.ui.main.fragments.OrdersFragment;
import com.jiujiu.mvvmTemplate.ui.main.fragments.ProductsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = ProductsFragmentModule.class)
    abstract ProductsFragment bindsProductsFragment();

    @ContributesAndroidInjector(modules = OrderFragmentModule.class)
    abstract OrdersFragment bindsOrdersFragment();

}
