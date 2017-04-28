/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mss60
 */
public class Clock {

    static int hours;
    static int minutes;
    static int day;
    static int dayCounter;
    static int month;
    static boolean marketState;

    public Clock() {
        dayCounter = 1;
        day = 1;
        hours = 0;
        minutes = 0;
        month = 1;
        run(96*4 + 4*16);            // 96 is equivalent to 24 hours
    }

    /**
     * Steps through the clock in 15 minute intervals
     * @param interval is the number of 15 minute steps to take
     */
    public static void run(int interval) {
        for (int i = 0; i < interval; i++) {
            minutes += 15;
            if (minutes == 60) {
                hours++;
                minutes = 0;
                if (hours == 9 && minutes == 0) {       // Market opens at 9am
                    marketState = true;
                }
                if (hours == 16 && minutes == 0) {      // Market closes at 4pm
                    marketState = false;
                }
                if (dayCounter == 6 || dayCounter == 7) {   // Market is closed on Saturday and Sunday
                    marketState = false;
                }
                if (day == 14 && month == 4) {          // Market is closed on Good Friday 
                    marketState = false;
                }
                if (day == 17 && month == 4) {          // Market is closed on Easter Monday
                    marketState = false;
                }
                if (day == 25 && month == 12) {         // Market is closed on Christmas Day
                    marketState = false;
                }
                if (day == 26 && month == 12) {         // Market is closed on Boxing Day
                    marketState = false;
                }
                if (hours == 24) {                      // Resets hours to 0 when midnight is reached
                    day++;
                    dayCounter++;
                    hours = 0;
                    if (dayCounter == 8) {              // Resets the day counter to 1 to begin the new week
                        dayCounter = 1;
                    }
                    if (day == 32 && month == 1) {      // Changes month to February 
                        day = 0;
                        month = 2;
                    }
                    if (day == 29 && month == 2) {      // Changes month to March
                        day = 0;
                        month = 3;
                    }
                    if (day == 32 && month == 3) {      // Changes month to April
                        day = 0;
                        month = 4;
                    }
                    if (day == 31 && month == 4) {      // Changes month to May
                        day = 0;
                        month = 5;
                    }
                    if (day == 32 && month == 5) {      // Changes month to June
                        day = 0;
                        month = 6;
                    }
                    if (day == 31 && month == 6) {      // Changes month to July
                        day = 0;
                        month = 7;
                    }
                    if (day == 32 && month == 7) {      // Changes month to August
                        day = 0;
                        month = 8;
                    }
                    if (day == 32 && month == 8) {      // Changes month to September
                        day = 0;
                        month = 9;
                    }
                    if (day == 31 && month == 9) {      // Changes month to October
                        day = 0;
                        month = 10;
                    }
                    if (day == 32 && month == 10) {      // Changes month to November
                        day = 0;
                        month = 11;
                    }
                    if (day == 31 && month == 11) {      // Changes month to Deceember
                        day = 0;
                        month = 12;
                    }
                    if (day == 32 && month == 12) {
                        day = 0;
                        month = 13;
                    }
                }
            }
        }       // end of loop
    }

    public static String simString(int h, int m) {
        String clockString = "";
        m = minutes;
        h = hours;
        if (h < 10) {
            clockString += 0;
        }
        clockString += Integer.toString(h);
        clockString += ":";
        clockString += Integer.toString(m);
        if (m == 0) {
            clockString += 0;
        }
        return clockString;
    }

    public static void main(String[] args) {
        Clock c = new Clock();
        System.out.println("day counter: " + dayCounter);
        System.out.println("day: " + day);
        System.out.println("month: " + month);
        System.out.println("time: " + simString(hours, minutes));
        System.out.println("market state: " + marketState);
    }

}
