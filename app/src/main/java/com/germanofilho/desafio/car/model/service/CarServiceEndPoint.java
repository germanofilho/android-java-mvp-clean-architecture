package com.germanofilho.desafio.car.model.service;

import com.germanofilho.desafio.core.model.domain.entity.Car;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by germano on 23/06/18.
 * germanof16@gmail.com
 */

interface CarServiceEndPoint {

    @GET("carro")
    Observable<List<Car>> getCars();

}
