package com.germanofilho.desafio.main.presentation.view.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.germanofilho.desafio.App;
import com.germanofilho.desafio.R;
import com.germanofilho.desafio.car.presentation.view.ui.fragment.CarListFragment;
import com.germanofilho.desafio.checkout.presentation.view.ui.fragment.CheckoutFragment;
import com.germanofilho.desafio.core.model.domain.entity.Car;
import com.germanofilho.desafio.core.view.ui.activity.BaseActivity;
import com.germanofilho.desafio.main.di.MainModule;
import com.germanofilho.desafio.main.presentation.presenter.MainPresenter;
import com.germanofilho.desafio.main.presentation.view.MainView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainView {

    @BindView(R.id.bottom_navigation) BottomNavigationView mBottomNavigationView;

    @BindView(R.id.toolbar) Toolbar mToolbar;

    @Inject protected MainPresenter mPresenter;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        App.get(this).getAppComponent()
                .plus(new MainModule(this))
                .inject(this);


        mPresenter.initViews();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(getIntent().getStringExtra(getString(R.string.param_go_to_checkout)) != null){
            mBottomNavigationView.setSelectedItemId(R.id.navigation_cart);
            return;
        }

        mBottomNavigationView.setSelectedItemId(R.id.navigation_car);
    }

    @Override
    public void setupBottomNavigation() {
            mBottomNavigationView.setOnNavigationItemSelectedListener(onBottomNavigationViewItemSelectedListener());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener onBottomNavigationViewItemSelectedListener() {
        return item -> {
            switch (item.getItemId()){
                case R.id.navigation_car:
                    addCarListFragment();
                    break;
                case R.id.navigation_cart:
                    addCheckoutFragment();
                    break;
            }
            return false;
        };
    }

    private void setContentLayout(Fragment fragment, String tag){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment, tag);
        fragmentTransaction.commit();
    }


    private void addCarListFragment(){
        Fragment fragment = CarListFragment.newInstance();
        String tag = CarListFragment.class.getSimpleName();
        setContentLayout(fragment, tag);
        mToolbar.setTitle(R.string.car_list);
    }

    private void addCheckoutFragment(){
        Fragment fragment = CheckoutFragment.newInstance();
        String tag = CheckoutFragment.class.getSimpleName();
        setContentLayout(fragment, tag);
        mToolbar.setTitle(R.string.cart);
    }
}
