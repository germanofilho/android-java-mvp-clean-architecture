package com.germanofilho.desafio.car.presentation.presenter;

import com.germanofilho.desafio.car.model.usecase.CarUseCase;
import com.germanofilho.desafio.car.presentation.view.CarView;
import com.germanofilho.desafio.core.model.domain.entity.Car;
import com.germanofilho.desafio.core.presenter.BasePresenterImpl;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by germano on 24/06/18.
 * germanof16@gmail.com
 */

public class CarListPresenterImpl extends BasePresenterImpl<CarView.CarList> implements CarPresenter.CarList {

    @Inject public CarUseCase.CarList mUseCase;

    @Inject public CarListPresenterImpl(){}

    @Override
    public void fetchCarList() {
        mView.isToShowProgressBar(true);
        Disposable disposable = execute(mUseCase.getCarList())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(it -> {
                            mView.isToShowProgressBar(false);
                            mView.initRecyclerView(it);
                        },
                        error -> {
                            mView.isToShowProgressBar(false);
                            mView.showError();

                        });

        mCompositeDisposable.add(disposable);
    }

    @Override
    public void onClickCart(Car car) {
        mUseCase.addCarCart(car);
        mView.addedCart();
    }

    @Override
    public void onClickCar(Car car) {
        mView.goToCarDetail(car);
    }

    @Override
    public void onStop() {
        mView.isToShowProgressBar(false);
        onDestroyPresenter();
    }
}
