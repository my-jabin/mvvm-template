package com.jiujiu.mvvmTemplate.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.jiujiu.mvvmTemplate.BR;
import com.jiujiu.mvvmTemplate.R;
import com.jiujiu.mvvmTemplate.databinding.ActivityMainBinding;
import com.jiujiu.mvvmTemplate.ui.base.BaseActivity;
import com.jiujiu.mvvmTemplate.ui.main.fragments.OrdersFragment;
import com.jiujiu.mvvmTemplate.ui.main.fragments.ProductsFragment;
import com.jiujiu.mvvmTemplate.ui.settings.SettingsActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import static com.jiujiu.mvvmTemplate.util.AppConstant.Tag.ORDERSFRAG;
import static com.jiujiu.mvvmTemplate.util.AppConstant.Tag.PRODUCTSFRAG;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainActivityViewModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupLayout();
    }

    private void setupLayout() {
        Toolbar toolbar = getBinding().toolbar;
        setSupportActionBar(toolbar);

        getBinding().bottomNavigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_navi_product:
                    Toast.makeText(this, "Products is clicked", Toast.LENGTH_SHORT).show();
                    showFragment(PRODUCTSFRAG);
                    return true;
                case R.id.bottom_navi_order:
                    Toast.makeText(this, "Orders is clicked", Toast.LENGTH_SHORT).show();
                    showFragment(ORDERSFRAG);
                    return true;
            }
            return true;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        showFragment(PRODUCTSFRAG);
    }


    private void showFragment(String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment productFrag = fragmentManager.findFragmentByTag(PRODUCTSFRAG);
        Fragment orderFrag = fragmentManager.findFragmentByTag(ORDERSFRAG);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (tag) {
            case PRODUCTSFRAG:
                if (productFrag == null) {
                    productFrag = ProductsFragment.getInstance();
                    fragmentTransaction.add(R.id.container, productFrag, PRODUCTSFRAG);
                }
                if (orderFrag != null) {
                    fragmentTransaction.hide(orderFrag);
                }
                fragmentTransaction.show(productFrag);
                break;
            case ORDERSFRAG:
                if (orderFrag == null) {
                    orderFrag = OrdersFragment.getInstance();
                    fragmentTransaction.add(R.id.container, orderFrag, ORDERSFRAG);
                }
                if (productFrag != null) {
                    fragmentTransaction.hide(productFrag);
                }
                fragmentTransaction.show(orderFrag);
                break;
            default:
                break;
        }
        fragmentTransaction.commit();
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
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
