package com.jode.site.jodeApi;

import java.util.Calendar;
import java.util.Date;

public class Utils {
    public static Date addOneMonth(Date date, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, amount);
        return cal.getTime();
    }
}
