package com.Khurram.Lloyds.dateToDay;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HumanClock {

    private String humanClockTime;

    private static final String[] belowTen = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] belowTwenty = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] belowSixty = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty"};

    public HumanClock(String timeString) {
        String result = LocalTime.parse(timeString, DateTimeFormatter.ofPattern("HH:mm")).format(DateTimeFormatter.ofPattern("hh:mm"));
        String englishTime = "";
        String[] time = result.split(":");
        int hours = Integer.parseInt(time[0]);
        int mins = Integer.parseInt(time[1]);

        if (mins == 0) {
            englishTime = (numberToWords(hours) + " o'clock");
        } else if (mins == 15) {
            englishTime = ("Quarter past " + numberToWords(hours).toLowerCase());
        } else if (mins == 30) {
            englishTime = ("Half past " + numberToWords(hours).toLowerCase());
        } else if (mins == 45) {
            int nextHour = hours + 1;
            if (nextHour == 13) {
                nextHour = 1;
            }
            englishTime = ("Quarter to " + numberToWords(nextHour).toLowerCase());
        } else if (mins > 0 && mins < 15 || mins > 15 && mins < 30) {
            englishTime = (numberToWords(mins) + " past " + numberToWords(hours).toLowerCase());
        } else if (mins > 30 && mins < 45 || mins > 45 && mins < 60) {
            int minsLeft = 60 - mins;
            int nextHour = hours + 1;
            if (nextHour == 13) {
                nextHour = 1;
            }
            englishTime = (numberToWords(minsLeft) + " to " + numberToWords(nextHour).toLowerCase());
        }

        this.humanClockTime = englishTime;
    }

    public static String numberToWords(int num) {
        if (num == 0) return "Zero";
        if (num == 60) return "Sixty";
        return helper(num);
    }

    private static String helper(int num) {
        String result = new String();
        if (num < 10) result = belowTen[num];
        else if (num < 20) result = belowTwenty[num - 10];
        else if (num < 60) result = belowSixty[num / 10] + " " + helper(num % 10).toLowerCase();
        return result.trim();
    }

    public String getHumanClockTime() {
        return humanClockTime;
    }


}
