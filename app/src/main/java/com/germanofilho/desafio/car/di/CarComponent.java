package com.germanofilho.desafio.car.di;

import com.germanofilho.desafio.car.presentation.view.ui.activity.CarDetailActivity;
import com.germanofilho.desafio.car.presentation.view.ui.fragment.CarListFragment;
import com.germanofilho.desafio.core.di.AppScope;

import dagger.Subcomponent;

/**
 * Created by germano on 24/06/18.
 * germanof16@gmail.com
 */
@AppScope
@Subcomponent(modules = CarModule.class)
public interface CarComponent {
    void inject(CarListFragment fragment);
    void inject(CarDetailActivity activity);
}
