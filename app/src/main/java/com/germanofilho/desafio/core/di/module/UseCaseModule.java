package com.germanofilho.desafio.core.di.module;


import com.germanofilho.desafio.car.model.usecase.CarDetailUseCaseImpl;
import com.germanofilho.desafio.car.model.usecase.CarUseCase;
import com.germanofilho.desafio.car.model.usecase.CarListUseCaseImpl;
import com.germanofilho.desafio.checkout.model.usecase.CheckoutUseCase;
import com.germanofilho.desafio.checkout.model.usecase.CheckoutUseCaseImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by germano on 22/06/18.
 * germanof16@gmail.com
 */

@Module
public class UseCaseModule {

    @Provides
    @Singleton
    CarUseCase.CarList provideCarListUseCase(CarListUseCaseImpl useCase){
        return useCase;
    }

    @Provides
    @Singleton
    CarUseCase.Detail provideCarDetailUseCase(CarDetailUseCaseImpl useCase){
        return useCase;
    }

    @Provides
    @Singleton
    CheckoutUseCase provideCheckoutUseCase(CheckoutUseCaseImpl useCase){
        return useCase;
    }
}
