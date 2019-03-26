package com.jiujiu.mvvmTemplate.di.module;

import com.jiujiu.mvvmTemplate.di.module.subModules.CustomerFragmentModule;
import com.jiujiu.mvvmTemplate.di.module.subModules.MainFragmentModule;
import com.jiujiu.mvvmTemplate.di.module.subModules.OrderFragmentModule;
import com.jiujiu.mvvmTemplate.di.module.subModules.ProductDetailFragmentModule;
import com.jiujiu.mvvmTemplate.di.module.subModules.ProductsFragmentModule;
import com.jiujiu.mvvmTemplate.ui.customers.CustomersFragment;
import com.jiujiu.mvvmTemplate.ui.main.MainFragment;
import com.jiujiu.mvvmTemplate.ui.orders.OrdersFragment;
import com.jiujiu.mvvmTemplate.ui.products.ProductsFragment;
import com.jiujiu.mvvmTemplate.ui.products.details.ProductDetailFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = MainFragmentModule.class)
    abstract MainFragment bindsMainFragment();

    @ContributesAndroidInjector(modules = ProductsFragmentModule.class)
    abstract ProductsFragment bindsProductsFragment();

    @ContributesAndroidInjector(modules = ProductDetailFragmentModule.class)
    abstract ProductDetailFragment bindsProductDetailFragment();

    @ContributesAndroidInjector(modules = OrderFragmentModule.class)
    abstract OrdersFragment bindsOrdersFragment();

    @ContributesAndroidInjector(modules = CustomerFragmentModule.class)
    abstract CustomersFragment bindsCustomerFragment();

}
