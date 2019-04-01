package com.jiujiu.mvvmTemplate.ui.main

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.databinding.library.baseAdapters.BR
import androidx.viewpager.widget.ViewPager
import com.jiujiu.mvvmTemplate.R
import com.jiujiu.mvvmTemplate.databinding.FragmentMainBinding
import com.jiujiu.mvvmTemplate.ui.base.BaseFragment
import org.jetbrains.anko.info

class MainFragment : BaseFragment<FragmentMainBinding, MainFragViewModel>() {

    override val bindingVariableId: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_main

    override val viewModelType: Class<MainFragViewModel>
        get() = MainFragViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupLayout()
        info("onViewCreated: ")
    }

    private fun setupLayout() {
        // set up view pager
        // nested fragment, using getChildFragmentManager() to obtain fragment manager
        binding.viewPager.adapter = MainViewPagerAdapter(childFragmentManager)
        binding.viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                val itemId = binding.bottomNavigation.menu.getItem(position).itemId
                binding.bottomNavigation.selectedItemId = itemId
            }
        })

        // setup bottom navigation view
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            showFragment(item.itemId)
            true
        }
    }

    private fun showFragment(@IdRes itemId: Int) {
        // the following fragment from state `onDestroyView` to `onViewCreated` if they are being switched
        when (itemId) {
            R.id.bottom_navi_order -> binding.viewPager.setCurrentItem(1, true)
            R.id.bottom_navi_customer -> binding.viewPager.setCurrentItem(2, true)
            else -> binding.viewPager.setCurrentItem(0, true)
        }
    }

}
