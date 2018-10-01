package com.germanofilho.desafio.core.model.service;

import com.germanofilho.desafio.BuildConfig;

/**
 * Created by germano on 24/06/18.
 * germanof16@gmail.com
 */

public class BaseServiceImpl implements BaseService{

    protected static String getBaseUrl(){
        return BuildConfig.BASE_URL;
    }
}
