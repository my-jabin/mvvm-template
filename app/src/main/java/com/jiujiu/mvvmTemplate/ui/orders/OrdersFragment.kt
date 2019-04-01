package com.jiujiu.mvvmTemplate.ui.orders


import android.os.Bundle
import android.view.View
import com.jiujiu.mvvmTemplate.BR
import com.jiujiu.mvvmTemplate.R
import com.jiujiu.mvvmTemplate.databinding.FragmentOrdersBinding
import com.jiujiu.mvvmTemplate.ui.base.BaseFragment
import org.jetbrains.anko.info


class OrdersFragment : BaseFragment<FragmentOrdersBinding, OrdersFragViewModel>() {

    override val bindingVariableId: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_orders

    override val viewModelType: Class<OrdersFragViewModel>
        get() = OrdersFragViewModel::class.java


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        info("onViewCreated: ")
    }

    private fun setupViewModel() {}

    companion object {
        fun getInstance(): OrdersFragment = OrdersFragment()
    }

}
