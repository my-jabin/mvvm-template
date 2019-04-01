package com.jiujiu.mvvmTemplate.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.jiujiu.mvvmTemplate.BR
import com.jiujiu.mvvmTemplate.R
import com.jiujiu.mvvmTemplate.databinding.ActivityMainBinding
import com.jiujiu.mvvmTemplate.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var mNavController: NavController

    override val viewModelClassType: Class<MainActivityViewModel>
        get() = MainActivityViewModel::class.java

    override val layoutId: Int
        get() = R.layout.activity_main

    override val bindingVariableId: Int
        get() = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupLayout()
    }

    private fun setupLayout() {
        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        mNavController = findNavController( R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration.Builder(mNavController.graph).build()
        NavigationUI.setupActionBarWithNavController(this, mNavController, appBarConfiguration)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_settings -> {
                mNavController.navigate(R.id.action_global_to_settingFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return mNavController.navigateUp() || super.onSupportNavigateUp()
    }
}
