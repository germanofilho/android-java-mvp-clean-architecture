package com.germanofilho.desafio.car.presentation.view;

import com.germanofilho.desafio.core.model.domain.entity.Car;
import com.germanofilho.desafio.core.view.BaseView;

import java.util.List;

/**
 * Created by germano on 23/06/18.
 * germanof16@gmail.com
 */

public interface CarView extends BaseView{

    interface Detail extends CarView{

        void loadData();

    }

    interface CarList extends CarView{
        void initRecyclerView(List<Car> carList);

        void goToCarDetail(Car car);

        void showError();

        void addedCart();
    }

}
