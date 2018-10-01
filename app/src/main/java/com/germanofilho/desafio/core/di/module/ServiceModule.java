package com.germanofilho.desafio.core.di.module;

import com.germanofilho.desafio.car.model.service.CarService;
import com.germanofilho.desafio.car.model.service.CarServiceImpl;
import com.germanofilho.desafio.core.model.service.BaseServiceImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by germano on 24/06/18.
 * germanof16@gmail.com
 */

@Module
public class ServiceModule {
    @Provides
    @Singleton
    BaseServiceImpl provideBaseService(BaseServiceImpl service) {
        return service;
    }

    @Provides
    @Singleton
    CarService provideCarService(CarServiceImpl service) {
        return service;
    }


}
