package com.germanofilho.desafio.checkout.presentation.view.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.germanofilho.desafio.App;
import com.germanofilho.desafio.R;
import com.germanofilho.desafio.checkout.di.CheckoutModule;
import com.germanofilho.desafio.checkout.presentation.presenter.CheckoutPresenter;
import com.germanofilho.desafio.checkout.presentation.view.CheckoutView;
import com.germanofilho.desafio.checkout.presentation.view.ui.adapter.CheckoutAdapter;
import com.germanofilho.desafio.core.model.domain.entity.Car;
import com.germanofilho.desafio.core.util.SingleToast;
import com.germanofilho.desafio.core.view.ui.fragment.BaseFragment;
import com.germanofilho.desafio.main.presentation.view.ui.activity.MainActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by germano on 27/06/18.
 * germanof16@gmail.com
 */

public class CheckoutFragment extends BaseFragment implements CheckoutView{

    @BindView(R.id.recycler_view_checkout)
    RecyclerView mRecyclerViewCheckout;

    @BindView(R.id.txt_empty_list)
    TextView emptyListLayout;

    @BindView(R.id.btn_buy)
    AppCompatButton btnBuy;

    @OnClick(R.id.btn_buy)
    void onClickBtnBuy(){
        mPresenter.finishBuy();
    }

    @Inject protected CheckoutPresenter mPresenter;

    private CheckoutAdapter recyclerViewAdapter;

    public static Fragment newInstance(){
        return new CheckoutFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.get(App.getInstance())
                .getAppComponent()
                .plus(new CheckoutModule(this))
                .inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_checkout_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initButterKnife();
        mPresenter.fetchCheckoutList();
    }

    @Override
    public void initRecyclerView(List<Car> carList) {
        recyclerViewAdapter = new CheckoutAdapter(getActivity(), carList);
        recyclerViewAdapter.setOnDeleteClicked(mPresenter::deleteItem);
        mRecyclerViewCheckout.setAdapter(recyclerViewAdapter);
        mRecyclerViewCheckout.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void emptyList() {
        emptyListLayout.setVisibility(View.VISIBLE);
        mRecyclerViewCheckout.setVisibility(View.GONE);
        btnBuy.setVisibility(View.GONE);
    }

    @Override
    public void updateList() {
        mPresenter.fetchCheckoutList();
    }

    @Override
    public void showMsgItemRemoved() {
        SingleToast.show(getActivity(), getString(R.string.removed_car_list), Toast.LENGTH_SHORT);
    }

    @Override
    public void showMsgBuySuccessful() {
        SingleToast.show(getActivity(), getString(R.string.successful_buy), Toast.LENGTH_SHORT);
    }

    @Override
    public void showMsgMaxLimit() {
        SingleToast.show(getActivity(), getString(R.string.max_limit), Toast.LENGTH_SHORT);
    }

    @Override
    public void goToMainActivity() {
        startActivity(new Intent(getActivity(), MainActivity.class));
    }
}
