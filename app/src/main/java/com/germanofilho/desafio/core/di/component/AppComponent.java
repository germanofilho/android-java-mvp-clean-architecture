package com.germanofilho.desafio.core.di.component;

import com.germanofilho.desafio.App;
import com.germanofilho.desafio.car.di.CarComponent;
import com.germanofilho.desafio.car.di.CarModule;
import com.germanofilho.desafio.checkout.di.CheckoutComponent;
import com.germanofilho.desafio.checkout.di.CheckoutModule;
import com.germanofilho.desafio.core.di.module.AppModule;
import com.germanofilho.desafio.core.di.module.BaseModule;
import com.germanofilho.desafio.main.di.MainComponent;
import com.germanofilho.desafio.main.di.MainModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by germano on 22/06/18.
 * germanof16@gmail.com
 */

@Singleton
@Component(modules = {AppModule.class, BaseModule.class})
public interface AppComponent {
    void inject(App app);
    MainComponent plus(MainModule module);
    CarComponent plus(CarModule module);
    CheckoutComponent plus(CheckoutModule module);
}
