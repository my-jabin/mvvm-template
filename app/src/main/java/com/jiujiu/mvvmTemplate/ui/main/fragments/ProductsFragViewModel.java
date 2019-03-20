package com.jiujiu.mvvmTemplate.ui.main.fragments;

import com.jiujiu.mvvmTemplate.data.DataManager;
import com.jiujiu.mvvmTemplate.data.model.Product;
import com.jiujiu.mvvmTemplate.ui.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.schedulers.Schedulers;

public class ProductsFragViewModel extends BaseViewModel {

    private static final String TAG = "ProductsFragViewModel";
    private MutableLiveData<List<Product>> productsLiveData = new MutableLiveData<>();

    @Inject
    public ProductsFragViewModel(DataManager dataManager) {
        super(dataManager);
    }


    public void loadProducts() {
        getCompositeDisposable().add(
                getDataManager()
                        .getAllProducts()
                        .subscribeOn(Schedulers.io())
                        .subscribe(
                                products -> productsLiveData.postValue(products)
                        )
        );
    }

    public LiveData<List<Product>> getProductLiveData() {
        return this.productsLiveData;
    }

}
