package com.germanofilho.desafio.main.di;

import com.germanofilho.desafio.core.di.AppScope;
import com.germanofilho.desafio.main.presentation.presenter.MainPresenter;
import com.germanofilho.desafio.main.presentation.presenter.MainPresenterImpl;
import com.germanofilho.desafio.main.presentation.view.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by germano on 23/06/18.
 * germanof16@gmail.com
 */

@Module
public class MainModule {

    private MainView mView;

    public MainModule(MainView view){
        mView = view;
    }

    @AppScope
    @Provides
    MainView provideMainView(){
        return mView;
    }

    @AppScope
    @Provides
    MainPresenter provideMainPresenter(MainPresenterImpl presenter){
        return presenter;
    }
}

