package com.germanofilho.desafio.core.view;

import android.view.View;

/**
 * Created by germano on 22/06/18.
 * germanof16@gmail.com
 */

public interface BaseView {

    void isToShowProgressBar(boolean value);

    interface Activity {
        View getView();
    }
}
