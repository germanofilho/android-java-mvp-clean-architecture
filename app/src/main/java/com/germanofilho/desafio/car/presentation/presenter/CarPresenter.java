package com.germanofilho.desafio.car.presentation.presenter;

import com.germanofilho.desafio.core.model.domain.entity.Car;
import com.germanofilho.desafio.core.presenter.BasePresenter;

/**
 * Created by germano on 24/06/18.
 * germanof16@gmail.com
 */

public interface CarPresenter extends BasePresenter{

    interface CarList{

        void fetchCarList();

        void onClickCar(Car car);

        void onClickCart(Car car);

        void onStop();

    }

    interface CarDetail{

        void addCar(Car car, int qtd);
    }


}
