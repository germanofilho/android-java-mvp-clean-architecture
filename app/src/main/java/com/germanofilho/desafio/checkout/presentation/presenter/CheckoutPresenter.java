package com.germanofilho.desafio.checkout.presentation.presenter;

import com.germanofilho.desafio.core.model.domain.entity.Car;

/**
 * Created by germano on 27/06/18.
 * germanof16@gmail.com
 */

public interface CheckoutPresenter {

    void fetchCheckoutList();

    void deleteItem(Car car);

    void finishBuy();
}
