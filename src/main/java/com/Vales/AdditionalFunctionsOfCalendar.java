package com.Vales;

import java.lang.Integer;import java.lang.String;import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class AdditionalFunctionsOfCalendar {
    private static final Map<String,Integer> MONTH;
    private static final Map<String,Integer> DAY;
    private static final int LOWERYEAR = 2000;
    private static final int UPPERYEAR = 3000;

    static {
        MONTH = new HashMap<String,Integer>(){
        {
            put("January",0);
            put("February",1);
            put("March",2);
            put("April",3);
            put("May",4);
            put("June",5);
            put("July",6);
            put("August",7);
            put("September",8);
            put("October",9);
            put("November",10);
            put("December",11);
        }
    };
        DAY = new HashMap<String,Integer>(){
            {
                put("Monday",2);
                put("Tuesday",3);
                put("Wednesday",4);
                put("Thursday",5);
                put("Friday",6);
                put("Saturday",7);
                put("Sunday",1);
            }
        };

    }

    public static Map<String, Integer> getMonth() {
        return MONTH;
    }

    public static Map<String, Integer> getDay() {
        return DAY;
    }

    private static Calendar cacheCalendar = Calendar.getInstance();

    public static int solution(int year, String firstMonth, String secondMonth, String firstDayInTheYear){

        if(!isCorrectYear(year)||!isCorrectMonths(firstMonth,secondMonth)||!isCorrectFirstDayInTheYear(year, firstDayInTheYear))
            return -1;
        getFirstMonday(year, MONTH.get(firstMonth));
        return  getCountAllWeek(MONTH.get(secondMonth));
    }

    public static boolean isCorrectYear(int year){
        return (year>LOWERYEAR&&year<UPPERYEAR);
    }

    public static boolean isCorrectMonths(String firstMonth, String secondMonth){

        return isCorrectNamesMonth(firstMonth,secondMonth)&&isCorrectSequenceMonth(firstMonth,secondMonth);
    }

    private static boolean isCorrectNamesMonth(String firstMonth,String secondMonth){
        return MONTH.containsKey(firstMonth)&& MONTH.containsKey(secondMonth);
    }

    private static boolean isCorrectSequenceMonth(String firstMonth,String secondMonth){
        return  MONTH.get(firstMonth)< MONTH.get(secondMonth);
    }

    private static int getFirstMonday(int year, int month) {
        cacheCalendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cacheCalendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
        cacheCalendar.set(Calendar.MONTH, month);
        cacheCalendar.set(Calendar.YEAR, year);
        return cacheCalendar.get(Calendar.DATE);
    }

    private static int getCountAllWeek(int numberLastMonth){
        int count = 0;
        for(;cacheCalendar.get(Calendar.MONTH)<=numberLastMonth;count++) {
            cacheCalendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            cacheCalendar.set(Calendar.DATE, (cacheCalendar.get(Calendar.DATE) + 7));
        }
        return count;
    }

    public static boolean isCorrectFirstDayInTheYear(int year, String firstDay) {

        cacheCalendar.set(Calendar.YEAR,year);
        cacheCalendar.set(Calendar.MONTH,0);
        cacheCalendar.set(Calendar.DATE,1);
        return DAY.containsKey(firstDay)&&cacheCalendar.get(Calendar.DAY_OF_WEEK)== DAY.get(firstDay);
    }

}
