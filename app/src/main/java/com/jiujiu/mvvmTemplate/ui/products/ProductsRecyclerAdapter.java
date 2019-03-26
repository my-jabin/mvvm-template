package com.jiujiu.mvvmTemplate.ui.products;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;

import com.jiujiu.mvvmTemplate.R;
import com.jiujiu.mvvmTemplate.data.model.Product;
import com.jiujiu.mvvmTemplate.databinding.ProductItemBinding;
import com.jiujiu.mvvmTemplate.ui.base.BaseRecyclerAdapter;
import com.jiujiu.mvvmTemplate.ui.main.MainFragmentDirections;

import java.util.Objects;

public class ProductsRecyclerAdapter extends BaseRecyclerAdapter<Product, ProductItemBinding> {
    private static final String TAG = "ProductsRecyclerAdapter";

    @Override
    public void bindViewHolder(@NonNull BaseViewHolder holder, ProductItemBinding binding, int position) {
        if (getmData() != null && getmData().size() != 0) {
            Product p = getmData().get(position);
            binding.tvProductItemName.setText(p.name);
            binding.setItemClickListener(v -> onProductItemClick(v, p));
        }
    }

    private void onProductItemClick(View v, Product p) {
        MainFragmentDirections.ActionMainFragmentToProductDetailFragment action = MainFragmentDirections.actionMainFragmentToProductDetailFragment(p.id, p.name);
        Navigation.findNavController(v).navigate(action);
    }

    @Override
    public int getItemLayourId() {
        return R.layout.product_item;
    }

    @Override
    public boolean areItemsTheSame(Product oldItem, Product newItem) {
        return Objects.equals(oldItem.id, newItem.id);
    }

    @Override
    public boolean areContentsTheSame(Product oldItem, Product newItem) {
        return Objects.equals(oldItem.name, newItem.name) &&
                Objects.equals(oldItem.brand, newItem.brand) &&
                Objects.equals(oldItem.price, newItem.price);
    }

}
