package com.germanofilho.desafio.car.presentation.view.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.germanofilho.desafio.App;
import com.germanofilho.desafio.R;
import com.germanofilho.desafio.car.di.CarModule;
import com.germanofilho.desafio.car.presentation.presenter.CarPresenter;
import com.germanofilho.desafio.car.presentation.view.CarView;
import com.germanofilho.desafio.core.model.domain.entity.Car;
import com.germanofilho.desafio.core.util.FormatNumber;
import com.germanofilho.desafio.core.util.SingleToast;
import com.germanofilho.desafio.core.view.ui.activity.BaseActivity;
import com.germanofilho.desafio.main.presentation.view.ui.activity.MainActivity;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class CarDetailActivity extends BaseActivity implements CarView.Detail {

    private Car mCar;

    @BindView(R.id.img_car_detail)
    ImageView imgCarDetail;

    @BindView(R.id.txt_detail_description)
    TextView textDescription;

    @BindView(R.id.txt_detail_brand)
    TextView textBrand;

    @BindView(R.id.txt_detail_price)
    TextView textPrice;

    @BindView(R.id.txt_detail_stock)
    TextView textStock;

    @BindView(R.id.spn_quantity)
    Spinner spnQuantity;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @OnClick(R.id.fab_cart)
    void onClickCart(){
        saveSeletedCar();
        showToastAddedCheckout();
    }

    @OnClick(R.id.btn_buy)
    void onClickBtnCart(){
        saveSeletedCar();
        showToastAddedCheckout();
    }

    @Inject protected CarPresenter.CarDetail mPresenter;

    @Override
    public int getLayout() {
        return R.layout.activity_car_detail;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        App.get(this).getAppComponent()
                .plus(new CarModule(this))
                .inject(this);

        mCar = getIntent().getParcelableExtra(getString(R.string.param_car));
        setUpToolbar();
        loadData();

    }

    private void setUpToolbar(){
        toolbar.setTitle(mCar.getNome());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }


    @Override
    public void loadData() {
        Picasso.get()
                .load(mCar.getImagem())
                .placeholder(R.drawable.placeholder)
                .into(imgCarDetail);

        textDescription.setText(mCar.getDescricao());
        textBrand.setText(mCar.getMarca());
        textPrice.setText(getString(R.string.total_value, FormatNumber.set(mCar.getPreco())));
        textStock.setText(getString(R.string.stock, mCar.getQuantidade()));
        loadSpinner();
    }


    //Max value to buy is 100.000 so 4x 25.000
    private void loadSpinner(){
        Integer[] items = new Integer[]{1,2,3,4};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,R.layout.spinner_item, items){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                if(convertView == null){
                    Log.i("spinnerView", "null");
                } else {
                    Log.i("spinnerView", "Ok");
                }

                return super.getView(position, convertView, parent);
            }
        };
        spnQuantity.setAdapter(adapter);
    }

    private void saveSeletedCar(){
        mPresenter.addCar(mCar, (int) spnQuantity.getSelectedItem());
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(getString(R.string.param_go_to_checkout), "");
        startActivity(intent);
        finishAffinity();
    }

    private void showToastAddedCheckout(){
        SingleToast.show(this, getString(R.string.add_car_in_cart), Toast.LENGTH_SHORT);
    }
}
