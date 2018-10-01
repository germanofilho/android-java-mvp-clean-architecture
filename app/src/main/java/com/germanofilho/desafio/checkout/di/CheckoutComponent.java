package com.germanofilho.desafio.checkout.di;

import com.germanofilho.desafio.checkout.presentation.view.ui.fragment.CheckoutFragment;
import com.germanofilho.desafio.core.di.AppScope;

import dagger.Subcomponent;

/**
 * Created by germano on 27/06/18.
 * germanof16@gmail.com
 */

@AppScope
@Subcomponent(modules = CheckoutModule.class)
public interface CheckoutComponent {
    void inject(CheckoutFragment fragment);
}

