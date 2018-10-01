package com.germanofilho.desafio.main.presentation.presenter;

import com.germanofilho.desafio.core.presenter.BasePresenterImpl;
import com.germanofilho.desafio.main.presentation.view.MainView;

import javax.inject.Inject;

/**
 * Created by germano on 23/06/18.
 * germanof16@gmail.com
 */

public class MainPresenterImpl extends BasePresenterImpl<MainView> implements MainPresenter{

    @Inject public MainPresenterImpl(){}

    @Override
    public void initViews() {
        mView.setupBottomNavigation();
    }
}
