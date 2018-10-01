package com.germanofilho.desafio.car.model.service;

import com.germanofilho.desafio.core.model.domain.entity.Car;
import com.germanofilho.desafio.core.model.service.BaseService;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by germano on 23/06/18.
 * germanof16@gmail.com
 */

public interface CarService extends BaseService {

    Observable<List<Car>> getCarList();
}
