package com.germanofilho.desafio.core.model.usecase;

import io.reactivex.Observable;

/**
 * Created by germano on 24/06/18.
 * germanof16@gmail.com
 */

public interface BaseUseCase {
    <T> Observable<T> execute(Observable<T> observable);
}
