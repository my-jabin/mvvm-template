package com.jiujiu.mvvmTemplate.ui.products

import android.view.View
import androidx.annotation.NonNull
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import com.jiujiu.mvvmTemplate.R
import com.jiujiu.mvvmTemplate.data.model.Product
import com.jiujiu.mvvmTemplate.databinding.ProductItemBinding
import com.jiujiu.mvvmTemplate.ui.base.BaseRecyclerListAdapter
import com.jiujiu.mvvmTemplate.ui.main.MainFragmentDirections

class ProductsRecyclerListerAdapter : BaseRecyclerListAdapter<Product, ProductItemBinding>(diff) {

    override val itemLayoutId: Int
        get() = R.layout.product_item

    override fun bindViewHolder(binding: ProductItemBinding, position: Int) {
        val p = getItem(position) ?: return
        with(binding) {
            product = p
            setItemClickListener { v -> onProductItemClick(v, p) }
        }
    }

    private fun onProductItemClick(v: View, @NonNull p: Product) {
        val action = MainFragmentDirections.actionMainFragmentToProductDetailFragment(p.id!!, p.name)
        Navigation.findNavController(v).navigate(action)
    }

}

val diff: DiffUtil.ItemCallback<Product> = object : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.name == newItem.name &&
                oldItem.brand == newItem.brand &&
                oldItem.price == newItem.price
    }
}