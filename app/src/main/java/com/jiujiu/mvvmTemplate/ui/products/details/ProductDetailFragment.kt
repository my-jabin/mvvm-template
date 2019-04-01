package com.jiujiu.mvvmTemplate.ui.products.details

import android.os.Bundle
import android.view.*
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.jiujiu.mvvmTemplate.BR
import com.jiujiu.mvvmTemplate.R
import com.jiujiu.mvvmTemplate.databinding.ProductDetailBinding
import com.jiujiu.mvvmTemplate.ui.base.BaseFragment
import org.jetbrains.anko.info

class ProductDetailFragment : BaseFragment<ProductDetailBinding, ProductDetailViewModel>() {

    override val bindingVariableId: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.product_detail

    override val viewModelType: Class<ProductDetailViewModel>
        get() = ProductDetailViewModel::class.java

    private val args: ProductDetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState).apply {
            setHasOptionsMenu(true)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadProductById(args.productId)
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.productLiveData.observe(this, Observer {
            it?.apply {
                info("product detail is refreshing")
                binding.product = it
//                binding.executePendingBindings()
            }
        })
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        // dynamically change option menu
        menu.findItem(R.id.menu_settings).setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER)
        super.onPrepareOptionsMenu(menu)
    }

}
