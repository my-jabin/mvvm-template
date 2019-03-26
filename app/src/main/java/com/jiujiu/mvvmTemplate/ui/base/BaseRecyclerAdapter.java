package com.jiujiu.mvvmTemplate.ui.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public abstract class BaseRecyclerAdapter<T, B extends ViewDataBinding> extends RecyclerView.Adapter<BaseRecyclerAdapter.BaseViewHolder<B>> {

    private Context mContext;
    private B mBinding;
    private List<T> mData;

    @NonNull
    @Override
    public BaseRecyclerAdapter.BaseViewHolder<B> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), getItemLayourId(), parent, false);
        return new BaseViewHolder<>(mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRecyclerAdapter.BaseViewHolder holder, int position) {
        bindViewHolder(holder, (B) holder.binding, position);
    }

    public abstract void bindViewHolder(@NonNull BaseRecyclerAdapter.BaseViewHolder holder, B binding, int position);

    @LayoutRes
    public abstract int getItemLayourId();

    public Context getContext() {
        return mContext;
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public List<T> getmData() {
        return mData;
    }

    public void setmData(List<T> data) {
        if (data == null || data.size() == 0) return;
        if (this.mData == null || this.mData.size() == 0) {
            this.mData = data;
            notifyItemRangeInserted(0, data.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return mData.size();
                }

                @Override
                public int getNewListSize() {
                    return data.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return BaseRecyclerAdapter.this.areItemsTheSame(mData.get(oldItemPosition), mData.get(newItemPosition));
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    return BaseRecyclerAdapter.this.areContentsTheSame(mData.get(oldItemPosition), mData.get(newItemPosition));
                }
            });
            this.mData = data;
            result.dispatchUpdatesTo(this);
        }
    }

    public abstract boolean areItemsTheSame(T oldItem, T newItem);

    public abstract boolean areContentsTheSame(T oldItem, T newItem);

    protected static class BaseViewHolder<B extends ViewDataBinding> extends RecyclerView.ViewHolder {
        B binding;

        BaseViewHolder(B binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}