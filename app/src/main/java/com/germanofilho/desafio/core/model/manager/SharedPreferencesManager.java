package com.germanofilho.desafio.core.model.manager;

import android.content.SharedPreferences;

import com.germanofilho.desafio.core.model.domain.entity.Car;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by germano on 26/06/18.
 * germanof16@gmail.com
 */

public class SharedPreferencesManager {

    private SharedPreferences mPreferences;

    public static final String CAR_LIST = "Car_List";


    @Inject public SharedPreferencesManager(SharedPreferences preferences){
        this.mPreferences = preferences;
    }

    public void writeCartList(List<Car> carList){
        SharedPreferences.Editor edit = mPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(carList);
        edit.putString(CAR_LIST, json);
        edit.apply();
    }

    public List<Car> readCarList(){
        if(mPreferences.contains(CAR_LIST)){
            List<Car> carList;
            String json = mPreferences.getString(CAR_LIST, null);
            Gson gson = new Gson();
            Car[] carItem =  gson.fromJson(json, Car[].class);
            carList = Arrays.asList(carItem);
            return new ArrayList<>(carList);
        } else {
            return null;
        }
    }

    public void addCar(Car car, int qtd){
        List<Car> carList = readCarList();
        if(carList == null) carList = new ArrayList<>();
        int lastPosition = 0;
        car.setQtdCart(qtd);

        for(int i = 0; i < carList.size(); i++) {
            if(carList.get(i).getId() == car.getId()){
                car.setQtdCart(carList.get(i).getqtdCart()+qtd);
                carList.remove(i);
                lastPosition = i;
            }
        }
        carList.add(lastPosition, car);
        writeCartList(carList);
    }

    public void removeCar(Car car){
        List<Car> carList = readCarList();
        int lastPosition = 0;

        for(int i = 0; i < carList.size(); i++) {
            if(carList.get(i).getId() == car.getId()){
                carList.remove(i);
                car.setQtdCart(car.getqtdCart()-1);
                lastPosition = i;
            }
        }

        if(car.getqtdCart() != 0){
            carList.add(lastPosition, car);
        }

        writeCartList(carList);
    }

    public void removeAll(){
        mPreferences.edit().remove(CAR_LIST).apply();
    }
}
