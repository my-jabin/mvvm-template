package com.jiujiu.mvvmTemplate.ui.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.jiujiu.mvvmTemplate.BR;
import com.jiujiu.mvvmTemplate.R;
import com.jiujiu.mvvmTemplate.databinding.ActivityMainBinding;
import com.jiujiu.mvvmTemplate.ui.base.BaseActivity;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainActivityViewModel> {

    private static final String TAG = "MainActivity";
    private AppBarConfiguration appBarConfiguration;
    private NavController mNavController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupLayout();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void setupLayout() {
        Toolbar toolbar = getBinding().toolbar;
        setSupportActionBar(toolbar);

        mNavController = Navigation.findNavController(this, R.id.nav_host_fragment);

        appBarConfiguration = new AppBarConfiguration.Builder(mNavController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, mNavController, appBarConfiguration);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_settings:
                mNavController.navigate(R.id.action_global_to_settingFragment);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        return mNavController.navigateUp() || super.onSupportNavigateUp();
    }

    @Override
    protected Class<MainActivityViewModel> getViewModelClassType() {
        return MainActivityViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public int getBindingVariableId() {
        return BR.viewModel;
    }

}
