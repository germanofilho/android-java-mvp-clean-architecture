package com.germanofilho.desafio;

import android.app.Application;
import android.content.Context;

import com.germanofilho.desafio.core.di.component.AppComponent;
import com.germanofilho.desafio.core.di.component.DaggerAppComponent;
import com.germanofilho.desafio.core.di.module.AppModule;


/**
 * Created by germano on 22/06/18.
 * germanof16@gmail.com
 */

public class App extends Application {

    private AppComponent mAppComponent;
    static App mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
    }

    private void initDagger() {
        mAppComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static App get(Context context){
        mInstance = (App) context.getApplicationContext();
        return mInstance;
    }

    public Context getContext(){
        return getApplicationContext();
    }

    public static App getInstance() {
        if (mInstance == null) {
            mInstance = new App();
        }

        return mInstance;
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

}
