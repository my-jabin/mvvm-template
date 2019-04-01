package com.jiujiu.mvvmTemplate.ui.base


import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerListAdapter<T, B : ViewDataBinding> protected constructor(
        diffCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, BaseRecyclerListAdapter.BaseViewHolder<B>>(diffCallback) {

    @get:LayoutRes
    abstract val itemLayoutId: Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRecyclerListAdapter.BaseViewHolder<B> {
        return BaseViewHolder(
                DataBindingUtil.inflate(LayoutInflater.from(parent.context), itemLayoutId, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<B>, position: Int) {
        bindViewHolder(holder.binding, position)
    }

    abstract fun bindViewHolder(binding: B, position: Int)

    class BaseViewHolder<B : ViewDataBinding> internal constructor(internal var binding: B) : RecyclerView.ViewHolder(binding.root)

}