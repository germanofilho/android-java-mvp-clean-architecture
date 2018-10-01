package com.germanofilho.desafio.core.model.service;

import com.germanofilho.desafio.App;

import javax.inject.Inject;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by germano on 24/06/18.
 * germanof16@gmail.com
 */

public class BaseServiceConnector {

    //cache 10mb
    private Cache cache = new Cache(App.getInstance().getCacheDir(), 10*1024*1024);
    private Retrofit.Builder mRetrofit;

    @Inject public BaseServiceConnector(Retrofit.Builder retrofit){
        this.mRetrofit = retrofit;
    }

    public <S> S request(String url, Class<S> service){
        return mRetrofit
                .baseUrl(url)
                .client(providesOkHttpClient())
                .build()
                .create(service);
    }


    private OkHttpClient providesOkHttpClient(){
        return new OkHttpClient.Builder().cache(cache).build();
    }
}
