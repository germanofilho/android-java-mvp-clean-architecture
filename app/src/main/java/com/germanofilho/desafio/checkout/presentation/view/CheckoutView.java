package com.germanofilho.desafio.checkout.presentation.view;

import com.germanofilho.desafio.core.model.domain.entity.Car;
import com.germanofilho.desafio.core.view.BaseView;

import java.util.List;

/**
 * Created by germano on 27/06/18.
 * germanof16@gmail.com
 */

public interface CheckoutView extends BaseView {


    void initRecyclerView(List<Car> carList);

    void emptyList();

    void updateList();

    void showMsgItemRemoved();

    void showMsgBuySuccessful();

    void showMsgMaxLimit();

    void goToMainActivity();
}
