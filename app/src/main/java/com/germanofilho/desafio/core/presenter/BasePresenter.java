package com.germanofilho.desafio.core.presenter;

import io.reactivex.Observable;

/**
 * Created by germano on 24/06/18.
 * germanof16@gmail.com
 */

public interface BasePresenter {

    <T> Observable<T> execute(Observable<T> observable);
    void onDestroyPresenter();
}
