package com.germanofilho.desafio.checkout.presentation.presenter;

import com.germanofilho.desafio.checkout.model.usecase.CheckoutUseCase;
import com.germanofilho.desafio.checkout.presentation.view.CheckoutView;
import com.germanofilho.desafio.core.model.domain.entity.Car;
import com.germanofilho.desafio.core.presenter.BasePresenterImpl;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by germano on 27/06/18.
 * germanof16@gmail.com
 */

public class CheckoutPresenterImpl extends BasePresenterImpl<CheckoutView> implements CheckoutPresenter {

    @Inject public CheckoutPresenterImpl(){}

    @Inject protected CheckoutUseCase mUseCase;

    private static int MAX_VALUE = 100000;

    @Override
    public void fetchCheckoutList() {
        List<Car> checkoutList = mUseCase.getListCheckout();

        if(checkoutList == null || checkoutList.isEmpty()){
            mView.emptyList();
            return;
        }

        mView.initRecyclerView(mUseCase.getListCheckout());
    }

    @Override
    public void deleteItem(Car car) {
        mUseCase.removeCheckoutItem(car);
        mView.showMsgItemRemoved();
        mView.updateList();
    }

    @Override
    public void finishBuy() {
        if(totalBuy() > MAX_VALUE){
            mView.showMsgMaxLimit();
            return;
        }
        mView.showMsgBuySuccessful();
        mUseCase.removeAll();
        mView.goToMainActivity();
    }

    private int totalBuy(){
        List<Car> list = mUseCase.getListCheckout();
        int total = 0;

        for (Car car: list) {
            total += car.getPreco()*car.getqtdCart();
        }

        return total;
    }
}
