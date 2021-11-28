package com.codeworm47.atmsimulator.bankservice.utils;

import java.util.Calendar;
import java.util.Date;

public final class DateUtils {
    public static Date nowUtc(){
        return new Date();
    }
    public static Date date(Integer year, Integer month, Integer day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }
}
