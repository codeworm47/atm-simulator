package com.codeworm47.atmsimulator.bankservice.util;

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
    public static Date addSecondToNow(int seconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowUtc());
        calendar.add(Calendar.SECOND, seconds);
        return calendar.getTime();
    }
}
