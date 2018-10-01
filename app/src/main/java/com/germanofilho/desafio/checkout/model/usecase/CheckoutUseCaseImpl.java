package com.germanofilho.desafio.checkout.model.usecase;

import com.germanofilho.desafio.core.model.domain.entity.Car;
import com.germanofilho.desafio.core.model.manager.SharedPreferencesManager;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by germano on 27/06/18.
 * germanof16@gmail.com
 */

public class CheckoutUseCaseImpl implements CheckoutUseCase {

    @Inject public CheckoutUseCaseImpl(){}

    @Inject protected SharedPreferencesManager preferences;

    @Override
    public List<Car> getListCheckout() {
        return preferences.readCarList();
    }

    @Override
    public void removeCheckoutItem(Car car) {
        preferences.removeCar(car);
    }

    @Override
    public void removeAll() {
        preferences.removeAll();
    }
}
