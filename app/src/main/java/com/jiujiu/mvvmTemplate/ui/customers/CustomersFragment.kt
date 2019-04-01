package com.jiujiu.mvvmTemplate.ui.customers

import android.os.Bundle
import android.view.View
import com.jiujiu.mvvmTemplate.BR
import com.jiujiu.mvvmTemplate.R
import com.jiujiu.mvvmTemplate.databinding.FragmentCustomersBinding
import com.jiujiu.mvvmTemplate.ui.base.BaseFragment
import org.jetbrains.anko.debug


class CustomersFragment : BaseFragment<FragmentCustomersBinding, CustomersFragViewModel>() {

    override val bindingVariableId: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_customers

    override val viewModelType: Class<CustomersFragViewModel>
        get() = CustomersFragViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        debug("onViewCreated: ")
    }

    private fun setupViewModel() {}

    companion object {
        fun getInstance(): CustomersFragment = CustomersFragment()
    }

}
