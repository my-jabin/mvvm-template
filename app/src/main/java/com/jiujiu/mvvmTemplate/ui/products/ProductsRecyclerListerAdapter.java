package com.jiujiu.mvvmTemplate.ui.products;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;

import com.jiujiu.mvvmTemplate.R;
import com.jiujiu.mvvmTemplate.data.model.Product;
import com.jiujiu.mvvmTemplate.databinding.ProductItemBinding;
import com.jiujiu.mvvmTemplate.ui.base.BaseRecyclerListAdapter;
import com.jiujiu.mvvmTemplate.ui.main.MainFragmentDirections;

import java.util.Objects;

public class ProductsRecyclerListerAdapter extends BaseRecyclerListAdapter<Product, ProductItemBinding> {
    private static final String TAG = "ProductsRecyclerListerAdapter";

    protected ProductsRecyclerListerAdapter() {
        super(diff);
    }

    @Override
    public void bindViewHolder(ProductItemBinding binding, int position) {
        Product p = getItem(position);
        if (p == null) return;
        binding.tvProductItemName.setText(p.name);
        binding.setItemClickListener(v -> onProductItemClick(v, p));
    }

    private void onProductItemClick(View v, Product p) {
        MainFragmentDirections.ActionMainFragmentToProductDetailFragment action = MainFragmentDirections.actionMainFragmentToProductDetailFragment(p.id, p.name);
        Navigation.findNavController(v).navigate(action);
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.product_item;
    }

    public static final DiffUtil.ItemCallback<Product> diff = new DiffUtil.ItemCallback<Product>() {
        @Override
        public boolean areItemsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return Objects.equals(oldItem.id, newItem.id);
        }

        @Override
        public boolean areContentsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return Objects.equals(oldItem.name, newItem.name) &&
                    Objects.equals(oldItem.brand, newItem.brand) &&
                    Objects.equals(oldItem.price, newItem.price);
        }
    };
}
