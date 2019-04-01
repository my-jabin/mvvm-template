package com.jiujiu.mvvmTemplate.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.jiujiu.mvvmTemplate.di.ViewModelFactory
import com.jiujiu.mvvmTemplate.di.scope.ViewModelKey
import com.jiujiu.mvvmTemplate.ui.customers.CustomersFragViewModel
import com.jiujiu.mvvmTemplate.ui.main.MainActivityViewModel
import com.jiujiu.mvvmTemplate.ui.main.MainFragViewModel
import com.jiujiu.mvvmTemplate.ui.orders.OrdersFragViewModel
import com.jiujiu.mvvmTemplate.ui.products.ProductsFragViewModel
import com.jiujiu.mvvmTemplate.ui.products.details.ProductDetailViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindsMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainFragViewModel::class)
    abstract fun bindsMainFragViewModel(viewModel: MainFragViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProductsFragViewModel::class)
    abstract fun bindsProductFragViewModel(viewModel: ProductsFragViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(OrdersFragViewModel::class)
    abstract fun bindsOrderFragViewModel(viewModel: OrdersFragViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CustomersFragViewModel::class)
    abstract fun bindsCustomerFragViewModel(viewModel: CustomersFragViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProductDetailViewModel::class)
    abstract fun bindsProductDetailViewModel(viewModel: ProductDetailViewModel): ViewModel


    @Binds
    abstract fun bindsViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
