package com.germanofilho.desafio.car.model.service;

import com.germanofilho.desafio.core.model.domain.entity.Car;
import com.germanofilho.desafio.core.model.service.BaseServiceImpl;
import com.germanofilho.desafio.core.model.service.BaseServiceConnector;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by germano on 24/06/18.
 * germanof16@gmail.com
 */

public class CarServiceImpl extends BaseServiceImpl implements CarService {

    private BaseServiceConnector mRetrofit;

    @Inject public CarServiceImpl(BaseServiceConnector retrofit){
        this.mRetrofit = retrofit;
    }


    @Override
    public Observable<List<Car>> getCarList() {
        return mRetrofit.request(getBaseUrl(), CarServiceEndPoint.class).getCars();
    }
}
