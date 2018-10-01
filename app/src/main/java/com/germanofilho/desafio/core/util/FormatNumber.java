package com.germanofilho.desafio.core.util;

import java.text.NumberFormat;
import java.util.Currency;

/**
 * Created by germano on 24/06/18.
 * germanof16@gmail.com
 */

public class FormatNumber {
    public static String set(Double n) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        currencyFormatter.setMaximumFractionDigits(0);
        return currencyFormatter.format(n);
    }
}