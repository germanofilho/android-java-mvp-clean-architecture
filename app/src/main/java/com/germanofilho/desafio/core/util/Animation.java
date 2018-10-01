package com.germanofilho.desafio.core.util;

import android.view.View;

/**
 * Created by germano on 22/06/18.
 * germanof16@gmail.com
 */

public abstract class Animation {
    public static void fadeIn(View view){
        view.setAlpha(0f);
        view.animate()
                .alpha(1f)
                .setDuration(300)
                .start();
    }

    public static void fadeInSlow(View view){
        view.setAlpha(0f);
        view.animate()
                .alpha(1f)
                .setDuration(800)
                .start();
    }


}
