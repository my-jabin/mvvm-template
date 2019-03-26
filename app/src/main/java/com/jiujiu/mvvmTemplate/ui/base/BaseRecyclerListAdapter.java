package com.jiujiu.mvvmTemplate.ui.base;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseRecyclerListAdapter<T, B extends ViewDataBinding> extends ListAdapter<T, BaseRecyclerListAdapter.BaseViewHolder<B>> {

    protected BaseRecyclerListAdapter(@NonNull DiffUtil.ItemCallback<T> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public BaseRecyclerListAdapter.BaseViewHolder<B> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        B mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), getItemLayoutId(), parent, false);
        return new BaseViewHolder<>(mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRecyclerListAdapter.BaseViewHolder holder, int position) {
        bindViewHolder((B) holder.binding, position);
    }

    public abstract void bindViewHolder(B binding, int position);

    @LayoutRes
    public abstract int getItemLayoutId();

    protected static class BaseViewHolder<B extends ViewDataBinding> extends RecyclerView.ViewHolder {
        B binding;

        BaseViewHolder(B binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}