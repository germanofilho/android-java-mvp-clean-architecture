package com.germanofilho.desafio.car.di;

import com.germanofilho.desafio.car.presentation.presenter.CarDetailPresenterImpl;
import com.germanofilho.desafio.car.presentation.presenter.CarPresenter;
import com.germanofilho.desafio.car.presentation.presenter.CarListPresenterImpl;
import com.germanofilho.desafio.car.presentation.view.CarView;
import com.germanofilho.desafio.core.di.AppScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by germano on 24/06/18.
 * germanof16@gmail.com
 */

@Module
public class CarModule {

    private CarView mView;

    public CarModule(CarView view){
        mView = view;
    }

    @AppScope
    @Provides
    CarView provideCarView(){
        return mView;
    }

    @Provides
    @AppScope
    CarView.CarList provideCarListView(){
        return (CarView.CarList) mView;
    }

    @Provides
    @AppScope
    CarView.Detail provideCarDetailView(){
        return (CarView.Detail) mView;
    }

    @AppScope
    @Provides
    CarPresenter.CarList provideCarListPresenter(CarListPresenterImpl presenter){
        return presenter;
    }

    @AppScope
    @Provides
    CarPresenter.CarDetail provideCarDetailPresenter(CarDetailPresenterImpl presenter){
        return presenter;
    }
}
