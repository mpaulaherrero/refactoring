package edu.ucv;

import java.util.Arrays;
import java.util.List;

public class Date {

    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;

    }

    public boolean validate() {
        if (day < 1 || day > getDaysOfMonth()){
            return false;
        }
        if (month < 1 || month > 12){
            return false;
        }
        return true;
    }

    private int getDaysOfMonth() {
        if(ifLongMonth())
            return 31;
        if(ifShortMonth())
            return 30;
        if(ifFebruary() && ifLeapYear())
            return 29;
        if(ifFebruary() && !ifLeapYear())
            return 28;
        return 0;
    }

    private boolean ifLeapYear() {
        return (year % 400 == 0) ||
                ((year % 4 == 0) && (year % 100 != 0));
    }

    private boolean ifLongMonth() {
        List<Integer> LONG_MONTH = Arrays.asList( 1,3,5,7,8,10,12 );
        return LONG_MONTH.contains(month);
    }

    private boolean ifShortMonth() {
        List<Integer> SHORT_MONTH = Arrays.asList(4,6,9,11);
        return SHORT_MONTH.contains(month);
    }

    private boolean ifFebruary() {
        return (month == 2);
    }

}
