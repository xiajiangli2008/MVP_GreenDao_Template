package com.redinfinity.template.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created on:8/10/16
 * Email:brucewzp@gmail.com
 **/
public class DateUtils {
    /**
     * 当前日期
     *
     * @return 2016-08-16
     */
    public static String currentDate() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(c.getTime());
    }

    /**
     * 当前月份第一天
     *
     * @return 2016-08-01
     */
    public static String firstDayOfMonth() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, 1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(c.getTime());
    }

    /**
     * 当前月份第一天
     *
     * @return 2016-08-01
     */
    public static String lastDayOfMonth() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH,
                c.getActualMaximum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(c.getTime());
    }

    /**
     * 得到上月月第一天的日期
     *
     * @Methods Name getFirstDayOfMonth
     * @return Date
     */
    public static String getFirstDayOfLastMonth() {
        Calendar c = Calendar.getInstance();
        int month = c.get(Calendar.MONTH);
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.DAY_OF_MONTH,
                c.getActualMinimum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(c.getTime());
    }

    /**
     * 得到上月最后一天的日期
     *
     * @Methods Name getLastDayOfMonth
     * @return Date
     */
    public static String getLastDayOfLastMonth() {
        Calendar c = Calendar.getInstance();
        int month = c.get(Calendar.MONTH);
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.DAY_OF_MONTH,
                c.getActualMaximum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(c.getTime());
    }

    /**
     * 本周第一天
     *
     * @return 返回本周的第一天
     */
    public static String firstDayOfWeek() {
        Calendar c = Calendar.getInstance(Locale.GERMANY);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(c.getTime());
    }

    /**
     * 本周最后一天
     *
     * @return 返回本周的最后一天
     */
    public static String lastDayOfWeek() {
        Calendar c = Calendar.getInstance(Locale.GERMANY);
        c.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(c.getTime());
    }



    /**
     * 昨天
     * @return 返回昨天:2016-08-10
     */
    public static String yesterday() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(c.getTime());
    }

    public static String DateToString(Date date){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String str=sdf.format(date);
        return str;
    }

    /**
     * 当前是否是本月第一天
     * @return true是第一天
     */
    public static boolean checkFirstDayOfMonth(){
        Calendar c = Calendar.getInstance();
        return (c.get(Calendar.DATE) == 1);
    }
}
