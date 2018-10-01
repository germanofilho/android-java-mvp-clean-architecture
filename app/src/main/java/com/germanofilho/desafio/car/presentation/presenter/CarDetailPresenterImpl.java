package com.germanofilho.desafio.car.presentation.presenter;

import com.germanofilho.desafio.car.model.usecase.CarUseCase;
import com.germanofilho.desafio.car.presentation.view.CarView;
import com.germanofilho.desafio.core.model.domain.entity.Car;
import com.germanofilho.desafio.core.presenter.BasePresenterImpl;

import javax.inject.Inject;

/**
 * Created by germano on 27/06/18.
 * germanof16@gmail.com
 */

public class CarDetailPresenterImpl extends BasePresenterImpl<CarView.Detail> implements CarPresenter.CarDetail{

    @Inject public CarDetailPresenterImpl(){}

    @Inject protected CarUseCase.Detail mUseCase;

    @Override
    public void addCar(Car car, int qtd) {
        mUseCase.addCarCart(car, qtd);
    }
}
