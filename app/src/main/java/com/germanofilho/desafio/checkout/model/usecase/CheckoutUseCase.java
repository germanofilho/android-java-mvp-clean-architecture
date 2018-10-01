package com.germanofilho.desafio.checkout.model.usecase;

import com.germanofilho.desafio.core.model.domain.entity.Car;

import java.util.List;

/**
 * Created by germano on 27/06/18.
 * germanof16@gmail.com
 */

public interface CheckoutUseCase {

    List<Car> getListCheckout();

    void removeCheckoutItem(Car car);

    void removeAll();
}
