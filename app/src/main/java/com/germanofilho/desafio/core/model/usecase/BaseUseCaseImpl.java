package com.germanofilho.desafio.core.model.usecase;

import com.germanofilho.desafio.core.model.manager.SharedPreferencesManager;
import com.germanofilho.desafio.core.model.service.BaseService;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by germano on 24/06/18.
 * germanof16@gmail.com
 */

public class BaseUseCaseImpl<S extends BaseService> implements BaseUseCase {


    @Inject protected S mService;

    @Inject protected SharedPreferencesManager preferences;

    protected S getService(){
        return mService;
    }

    @Override
    public <T> Observable<T> execute(Observable<T> observable) {
        //TODO
        return observable;
    }
}
