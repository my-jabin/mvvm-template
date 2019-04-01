package com.jiujiu.mvvmTemplate.ui.base

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.AnkoLogger
import javax.inject.Inject

abstract class BaseActivity<T : ViewDataBinding, V : ViewModel> : DaggerAppCompatActivity(), AnkoLogger {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    lateinit var binding: T
        private set

    lateinit var viewModel: V
        private set

    protected abstract val viewModelClassType: Class<V>

    @get:LayoutRes
    abstract val layoutId: Int

    abstract val bindingVariableId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performViewModel()
        performDataBinding()
    }

    private fun performViewModel() {
        viewModel = ViewModelProviders.of(this, factory).get(viewModelClassType)
    }

    private fun performDataBinding() {
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this
        binding.setVariable(bindingVariableId, viewModel)
        binding.executePendingBindings()
    }

    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

}
