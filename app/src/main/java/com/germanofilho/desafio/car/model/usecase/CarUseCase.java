package com.germanofilho.desafio.car.model.usecase;

import com.germanofilho.desafio.core.model.domain.entity.Car;
import com.germanofilho.desafio.core.model.service.BaseService;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by germano on 24/06/18.
 * germanof16@gmail.com
 */

public interface CarUseCase{

    interface CarList extends BaseService{
        Observable<List<Car>> getCarList();

        void addCarCart(Car car);
    }


    interface Detail{
        void addCarCart(Car car, int qtd);
    }

}
