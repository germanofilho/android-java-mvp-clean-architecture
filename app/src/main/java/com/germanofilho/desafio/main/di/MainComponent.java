package com.germanofilho.desafio.main.di;

import com.germanofilho.desafio.core.di.AppScope;
import com.germanofilho.desafio.main.presentation.view.ui.activity.MainActivity;

import dagger.Subcomponent;

/**
 * Created by germano on 23/06/18.
 * germanof16@gmail.com
 */

@AppScope
@Subcomponent(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity activity);
}