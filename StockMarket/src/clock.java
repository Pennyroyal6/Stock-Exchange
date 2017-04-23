/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mss60
 */
public class clock {

    static int hours;
    static int minutes;
    static int days;
    static int dayCounter;
    static String currentDay;

    public clock() {
        dayCounter = 2;
        hours = 0;
        minutes = 0;
    }

    public static void run() {
        for (int i = 0; i < 7; i++) {
            if (dayCounter == 1) {
                currentDay = "Monday";
            }
            minutes += 15;
            if (minutes == 60) {
                hours++;
                minutes = 0;
                if (hours == 24) {
                    days++;
                    dayCounter++;
                    if (dayCounter == 2) {
                        currentDay = "Tuesday";
                    } else if (dayCounter == 3) {
                        currentDay = "Wednesday";
                    } else if (dayCounter == 4) {
                        currentDay = "Thursday";
                    } else if (dayCounter == 5) {
                        currentDay = "Friday";
                    } else if (dayCounter == 6) {
                        currentDay = "Saturday";
                    } else if (dayCounter == 7) {
                        currentDay = "Sunday";
                    }
                    hours = 0;
                }
            }
        }
    }

    public static String simString(int h, int m) {
        String clockString = "";
        m = minutes;
        h = hours;
        clockString += currentDay;
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
        run();
        System.out.println(minutes);
        System.out.println(days);
        System.out.println(simString(hours, minutes));
    }

}
