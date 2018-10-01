package com.germanofilho.desafio.core.presenter;

import com.germanofilho.desafio.core.view.BaseView;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by germano on 22/06/18.
 * germanof16@gmail.com
 */

public class BasePresenterImpl<V extends BaseView> implements BasePresenter{

    @Inject protected V mView;

    public CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    protected V getView(){
        return mView;
    }


    @Override
    public <T> Observable<T> execute(Observable<T> observable) {
        return observable;
    }

    @Override
    public void onDestroyPresenter() {
        mCompositeDisposable.clear();
    }
}
