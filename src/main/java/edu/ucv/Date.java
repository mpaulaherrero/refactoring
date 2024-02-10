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
        if (day < 1 || day > 31){
            return false;
        }
        if (month < 1 || month > 12){
            return false;
        }

        if(day > getDaysOfMonth()){
            return false;
        } else {
            return true;
        }
    }

    private int getDaysOfMonth() {
        int daysOfMonth = 0;
        if(ifLongMonth(month)) {
            daysOfMonth = 31;
        } else if(ifShortMonth(month)) {
            daysOfMonth = 30;
        } else if(ifFebruary(month) && ifLeapYear()) {
            daysOfMonth = 29;
        } else if(ifFebruary(month) && !ifLeapYear()){
            daysOfMonth = 28;
        }
        return daysOfMonth;
    }

    private boolean ifLeapYear() {
        return (year % 400 == 0) ||
                ((year % 4 == 0) && (year % 100 != 0));
    }

    private boolean ifLongMonth(int month) {
        List<Integer> LONG_MONTH = Arrays.asList( 1,3,5,7,8,10,12 );
        return LONG_MONTH.contains(month);
    }

    private boolean ifShortMonth(int month) {
        List<Integer> SHORT_MONTH = Arrays.asList(4,6,9,11);
        return SHORT_MONTH.contains(month);
    }

    private boolean ifFebruary(int month) {
        return (month == 2);
    }

}
