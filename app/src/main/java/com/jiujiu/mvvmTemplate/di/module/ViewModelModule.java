package com.jiujiu.mvvmTemplate.di.module;

import com.jiujiu.mvvmTemplate.di.ViewModelFactory;
import com.jiujiu.mvvmTemplate.di.scope.ViewModelKey;
import com.jiujiu.mvvmTemplate.ui.main.MainActivityViewModel;
import com.jiujiu.mvvmTemplate.ui.main.fragments.OrdersFragViewModel;
import com.jiujiu.mvvmTemplate.ui.main.fragments.ProductsFragViewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

//    @Binds
//    @IntoMap
//    @ViewModelKey(SettingsActivityViewModel.class)
//    abstract ViewModel bindsSettingsActivityViewModel(SettingsActivityViewModel viewModel);


    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel.class)
    abstract ViewModel bindsMainActivityViewModel(MainActivityViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ProductsFragViewModel.class)
    abstract ViewModel bindsProductFragViewModel(ProductsFragViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(OrdersFragViewModel.class)
    abstract ViewModel bindsOrderFragViewModel(OrdersFragViewModel viewModel);


    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory factory);
}
