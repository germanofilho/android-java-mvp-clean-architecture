package com.germanofilho.desafio.core.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by germano on 27/06/18.
 * germanof16@gmail.com
 */

public class SingleToast {

    private static Toast mToast;

    public static void show(Context context, String text, int duration) {
        if (mToast != null) mToast.cancel();
        mToast = Toast.makeText(context, text, duration);
        mToast.show();
    }
}