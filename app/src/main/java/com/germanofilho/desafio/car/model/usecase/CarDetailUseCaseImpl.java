package com.germanofilho.desafio.car.model.usecase;

import com.germanofilho.desafio.core.model.domain.entity.Car;
import com.germanofilho.desafio.core.model.manager.SharedPreferencesManager;

import javax.inject.Inject;

/**
 * Created by germano on 27/06/18.
 * germanof16@gmail.com
 */

public class CarDetailUseCaseImpl implements CarUseCase.Detail {

    @Inject public CarDetailUseCaseImpl(){}

    @Inject protected SharedPreferencesManager preferences;

    @Override
    public void addCarCart(Car car, int qtd) {
        preferences.addCar(car, qtd);
    }
}
