package com.jiujiu.mvvmTemplate.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.jiujiu.mvvmTemplate.di.ViewModelFactory;
import com.jiujiu.mvvmTemplate.di.scope.ViewModelKey;
import com.jiujiu.mvvmTemplate.ui.customers.CustomersFragViewModel;
import com.jiujiu.mvvmTemplate.ui.main.MainActivityViewModel;
import com.jiujiu.mvvmTemplate.ui.main.MainFragViewModel;
import com.jiujiu.mvvmTemplate.ui.orders.OrdersFragViewModel;
import com.jiujiu.mvvmTemplate.ui.products.ProductsFragViewModel;
import com.jiujiu.mvvmTemplate.ui.products.details.ProductDetailViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel.class)
    abstract ViewModel bindsMainActivityViewModel(MainActivityViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(MainFragViewModel.class)
    abstract ViewModel bindsMainFragViewModel(MainFragViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ProductsFragViewModel.class)
    abstract ViewModel bindsProductFragViewModel(ProductsFragViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(OrdersFragViewModel.class)
    abstract ViewModel bindsOrderFragViewModel(OrdersFragViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(CustomersFragViewModel.class)
    abstract ViewModel bindsCustomerFragViewModel(CustomersFragViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ProductDetailViewModel.class)
    abstract ViewModel bindsProductDetailViewModel(ProductDetailViewModel viewModel);


    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory factory);
}
