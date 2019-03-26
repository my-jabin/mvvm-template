package com.jiujiu.mvvmTemplate.ui.products;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.jiujiu.mvvmTemplate.data.DataManager;
import com.jiujiu.mvvmTemplate.data.model.Product;
import com.jiujiu.mvvmTemplate.ui.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.schedulers.Schedulers;

public class ProductsFragViewModel extends BaseViewModel {

    private static final String TAG = "ProductsFragViewModel";
    private MutableLiveData<List<Product>> productsLiveData = new MutableLiveData<>();

    @Inject
    public ProductsFragViewModel(DataManager dataManager) {
        super(dataManager);
        loadProducts();
    }

    private void loadProducts() {
        getCompositeDisposable().add(
                getDataManager()
                        .getAllProducts()
                        .subscribeOn(Schedulers.io())
                        .subscribe(
                                products -> {
                                    Log.d(TAG, "loadProducts: finish. Size = " + products.size());
                                    productsLiveData.postValue(products);
                                }
                        )
        );
    }

    public LiveData<List<Product>> getProductLiveData() {
        return this.productsLiveData;
    }

}
