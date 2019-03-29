package com.jiujiu.mvvmTemplate.ui.products.details;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.jiujiu.mvvmTemplate.data.DataManager;
import com.jiujiu.mvvmTemplate.data.model.Product;
import com.jiujiu.mvvmTemplate.ui.base.BaseViewModel;

import javax.inject.Inject;

import io.reactivex.schedulers.Schedulers;

public class ProductDetailViewModel extends BaseViewModel {

    private static final String TAG = "ProductDetailViewModel";

    private MutableLiveData<Product> mProductLiveData = new MutableLiveData<>();

    @Inject
    public ProductDetailViewModel(DataManager dataManager) {
        super(dataManager);
    }

    public void loadProductById(Long productId) {
        getCompositeDisposable().add(
                this.getDataManager().getProductById(productId)
                        .subscribeOn(Schedulers.io())
                        .subscribe(product -> {
                            if (product != null)
                                mProductLiveData.postValue(product);
                        }, throwable -> {
                            throwable.printStackTrace();
                        })
        );
    }

    public LiveData<Product> getProductLiveData() {
        return mProductLiveData;
    }
}
