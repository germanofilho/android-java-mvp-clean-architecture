package com.germanofilho.desafio.core.di.module;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.germanofilho.desafio.core.model.manager.SharedPreferencesManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by germano on 22/06/18.
 * germanof16@gmail.com
 */

@Module(includes = {UseCaseModule.class, ServiceModule.class, NetworkModule.class})
public class AppModule {

    private Application mApplication;

    public AppModule(Application application){
        this.mApplication = application;
    }

    @Provides
    @Singleton
    Application provideApplication(){
        return mApplication;
    }

    @Provides
    @Singleton
    SharedPreferencesManager provideSharedPreferences(Application app)  {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(app);
        return new SharedPreferencesManager(preferences);
    }
}
