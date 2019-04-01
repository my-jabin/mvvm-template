package com.jiujiu.mvvmTemplate.di.module

import com.jiujiu.mvvmTemplate.di.module.subModules.*
import com.jiujiu.mvvmTemplate.ui.customers.CustomersFragment
import com.jiujiu.mvvmTemplate.ui.main.MainFragment
import com.jiujiu.mvvmTemplate.ui.orders.OrdersFragment
import com.jiujiu.mvvmTemplate.ui.products.ProductsFragment
import com.jiujiu.mvvmTemplate.ui.products.details.ProductDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun bindsMainFragment(): MainFragment

    @ContributesAndroidInjector(modules = [ProductsFragmentModule::class])
    abstract fun bindsProductsFragment(): ProductsFragment

    @ContributesAndroidInjector(modules = [ProductDetailFragmentModule::class])
    abstract fun bindsProductDetailFragment(): ProductDetailFragment

    @ContributesAndroidInjector(modules = [OrderFragmentModule::class])
    abstract fun bindsOrdersFragment(): OrdersFragment

    @ContributesAndroidInjector(modules = [CustomerFragmentModule::class])
    abstract fun bindsCustomerFragment(): CustomersFragment

}
