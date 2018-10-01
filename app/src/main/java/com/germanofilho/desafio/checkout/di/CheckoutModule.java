package com.germanofilho.desafio.checkout.di;

import com.germanofilho.desafio.checkout.presentation.presenter.CheckoutPresenter;
import com.germanofilho.desafio.checkout.presentation.presenter.CheckoutPresenterImpl;
import com.germanofilho.desafio.checkout.presentation.view.CheckoutView;
import com.germanofilho.desafio.core.di.AppScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by germano on 27/06/18.
 * germanof16@gmail.com
 */

@Module
public class CheckoutModule {

    private CheckoutView mView;

    public CheckoutModule(CheckoutView view){
        mView = view;
    }

    @AppScope
    @Provides
    CheckoutView provideCheckoutView(){
        return mView;
    }

    @AppScope
    @Provides
    CheckoutPresenter provideCheckoutPresenter(CheckoutPresenterImpl presenter){
        return presenter;
    }

}