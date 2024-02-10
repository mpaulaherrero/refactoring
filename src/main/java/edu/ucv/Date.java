package edu.ucv;

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
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daysOfMonth = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                daysOfMonth = 30;
                break;
            case 2:
                if (ifLeapYear())
                    daysOfMonth = 29;
                else
                    daysOfMonth = 28;
                break;
        }
        return daysOfMonth;
    }

    private boolean ifLeapYear() {
        return (year % 400 == 0) ||
                ((year % 4 == 0) && (year % 100 != 0));
    }

}
