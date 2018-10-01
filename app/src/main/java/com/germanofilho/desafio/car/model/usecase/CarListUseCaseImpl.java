package com.germanofilho.desafio.car.model.usecase;

import com.germanofilho.desafio.car.model.service.CarService;
import com.germanofilho.desafio.core.model.domain.entity.Car;
import com.germanofilho.desafio.core.model.usecase.BaseUseCase;
import com.germanofilho.desafio.core.model.usecase.BaseUseCaseImpl;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by germano on 24/06/18.
 * germanof16@gmail.com
 */

public class CarListUseCaseImpl extends BaseUseCaseImpl<CarService> implements CarUseCase.CarList {

    @Inject public CarListUseCaseImpl(){}

    @Override
    public Observable<List<Car>> getCarList() {
        return execute(mService.getCarList());
    }

    @Override
    public void addCarCart(Car car) {
        preferences.addCar(car, 1);
    }
}
