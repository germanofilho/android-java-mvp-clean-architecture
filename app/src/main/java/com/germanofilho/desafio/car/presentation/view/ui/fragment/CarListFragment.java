package com.germanofilho.desafio.car.presentation.view.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.germanofilho.desafio.App;
import com.germanofilho.desafio.R;
import com.germanofilho.desafio.car.di.CarModule;
import com.germanofilho.desafio.car.presentation.presenter.CarPresenter;
import com.germanofilho.desafio.car.presentation.view.CarView;
import com.germanofilho.desafio.car.presentation.view.ui.activity.CarDetailActivity;
import com.germanofilho.desafio.car.presentation.view.ui.adapter.CarAdapter;
import com.germanofilho.desafio.core.model.domain.entity.Car;
import com.germanofilho.desafio.core.util.SingleToast;
import com.germanofilho.desafio.core.view.ui.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by germano on 23/06/18.
 * germanof16@gmail.com
 */

public class CarListFragment extends BaseFragment implements CarView.CarList{

    @Inject public CarPresenter.CarList mPresenter;

    @BindView(R.id.recycler_view_car)
    RecyclerView mRecyclerViewCar;

    public static Fragment newInstance(){
        return new CarListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.get(App.getInstance())
                .getAppComponent()
                .plus(new CarModule(this))
                .inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_car_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initButterKnife();
        mPresenter.fetchCarList();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    public void initRecyclerView(List<Car> carList) {
        CarAdapter recyclerViewAdapter = new CarAdapter(getActivity(), carList);
        recyclerViewAdapter.setOnCarClicked(mPresenter::onClickCar);
        recyclerViewAdapter.setOnCartClicked(mPresenter::onClickCart);
        mRecyclerViewCar.setAdapter(recyclerViewAdapter);
        mRecyclerViewCar.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void goToCarDetail(Car car) {
        Intent intent = new Intent(getActivity(), CarDetailActivity.class);
        intent.putExtra(getString(R.string.param_car), car);
        startActivity(intent);
    }

    @Override
    public void showError() {
        SingleToast.show(getActivity(), getString(R.string.error_car_list), Toast.LENGTH_SHORT);
    }

    @Override
    public void addedCart() {
        SingleToast.show(getActivity(), getString(R.string.add_car_in_cart), Toast.LENGTH_SHORT);
    }
}
