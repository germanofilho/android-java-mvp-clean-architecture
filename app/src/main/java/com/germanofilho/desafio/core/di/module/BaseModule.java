package com.germanofilho.desafio.core.di.module;

import com.germanofilho.desafio.core.view.BaseView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by germano on 22/06/18.
 * germanof16@gmail.com
 */

@Module
public class BaseModule {

    private BaseView mBaseView;

    public BaseModule(BaseView baseView){
        this.mBaseView = baseView;
    }

    @Provides
    @Singleton
    BaseView.Activity providesBaseActivityView(){
        return (BaseView.Activity) mBaseView;
    }

}
