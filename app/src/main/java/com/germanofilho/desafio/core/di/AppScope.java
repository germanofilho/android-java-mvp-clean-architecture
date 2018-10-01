package com.germanofilho.desafio.core.di;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by germano on 22/06/18.
 * germanof16@gmail.com
 */

@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface AppScope {}
