package com.germanofilho.desafio.core.di.module;

import com.germanofilho.desafio.core.model.service.BaseServiceConnector;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by germano on 24/06/18.
 * germanof16@gmail.com
 */

@Module
public class NetworkModule {

    @Provides
    @Singleton
    Retrofit.Builder provideRetrofit() {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
    }

    @Provides
    @Singleton
    BaseServiceConnector provideBaseServiceConnector(Retrofit.Builder retrofit)  {
        return new BaseServiceConnector(retrofit);
    }
}
