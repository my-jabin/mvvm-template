package com.jiujiu.mvvmTemplate.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import dagger.android.AndroidInjection;

public abstract class BaseActivity<T extends ViewDataBinding, V extends ViewModel> extends AppCompatActivity {

    private T mBinding;
    private V viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        performDenpendencyInjection();
        super.onCreate(savedInstanceState);
        performViewModel();
        performDataBinding();
    }

    private void performViewModel() {
        viewModel = generateViewModel();
    }

    protected abstract V generateViewModel();

    @LayoutRes
    public abstract int getLayoutId();

    public V getViewModel() {
        return viewModel;
    }

    public void performDataBinding() {
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());
        viewModel = viewModel == null ? getViewModel() : viewModel;
        mBinding.setVariable(getBindingVariableId(), viewModel);
        mBinding.executePendingBindings();
    }


    public void performDenpendencyInjection() {
        AndroidInjection.inject(this);
    }

    public abstract int getBindingVariableId();

    public T getBinding() {
        return mBinding;
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }
}
