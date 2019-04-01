package com.jiujiu.mvvmTemplate.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import org.jetbrains.anko.AnkoLogger
import javax.inject.Inject

abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel> : DaggerFragment(), AnkoLogger {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    lateinit var binding: T
        private set
    lateinit var viewModel: V
        private set

    protected abstract val bindingVariableId: Int

    @get:LayoutRes
    protected abstract val layoutId: Int

    protected abstract val viewModelType: Class<V>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = generateViewmodel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setVariable(bindingVariableId, viewModel)
        binding.executePendingBindings()
    }

    private fun generateViewmodel(): V {
        return ViewModelProviders.of(this, factory).get(viewModelType)
    }
}
