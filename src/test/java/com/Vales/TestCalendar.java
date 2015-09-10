package com.Vales;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.*;


public class TestCalendar {



    @Test
    public void testYearRange(){
        assertFalse("Incorrect installed lower limit of the year ", AdditionalFunctionsOfCalendar.isCorrectYear(2000));
        assertTrue("Incorrect installed lower limit of the year ", AdditionalFunctionsOfCalendar.isCorrectYear(2001));
        assertFalse("Incorrect installed upper limit of the year ", AdditionalFunctionsOfCalendar.isCorrectYear(3000));
        assertTrue("Incorrect installed upper limit of the year ", AdditionalFunctionsOfCalendar.isCorrectYear(2999));

    }

    //TODO just thinking, will exist sense to check order months
    @Test
    public void testValidMonthName(){
        ArrayList<String> month = new ArrayList<String>(){{

                add("January");
                add("February");
                add("March");
                add("April");
                add("May");
                add("June");
                add("July");
                add("August");
                add("September");
                add("October");
                add("November");
                add("December");
            }
        };
        Map takenMap = AdditionalFunctionsOfCalendar.getMonth();
        month.forEach(s -> assertTrue("Incorrect month name",takenMap.containsKey(s)));
    }

    //TODO just thinking, will exist sense to check order days
        @Test
    public void testValidDayName(){
        ArrayList<String> day = new ArrayList<String>(){{
            add("Monday");
            add("Tuesday");
            add("Wednesday");
            add("Thursday");
            add("Friday");
            add("Saturday");
            add("Sunday");
            }
        };
        Map takenMap = AdditionalFunctionsOfCalendar.getDay();
        day.forEach(s -> assertTrue("Incorrect day name",takenMap.containsKey(s)));
    }

    @Test
    public void testCorrectSequenceMonth(){
        assertTrue("Incorrect month sequence",AdditionalFunctionsOfCalendar.isCorrectMonths("April","May"));
        assertFalse("Incorrect month sequence",AdditionalFunctionsOfCalendar.isCorrectMonths("May","April"));
    }

    @Test
    public void testCorrectFirstDayOfTheWeek(){
        assertTrue("Incorrect first day in he year",AdditionalFunctionsOfCalendar.isCorrectFirstDayInTheYear(2015,"Thursday"));
        assertFalse("Incorrect first day in he year",AdditionalFunctionsOfCalendar.isCorrectFirstDayInTheYear(2015, "Wednesday"));
    }

    @Test
    public void testGeneral(){
        assertEquals(7,AdditionalFunctionsOfCalendar.solution(2014, "April", "May", "Wednesday"));
    }
}
