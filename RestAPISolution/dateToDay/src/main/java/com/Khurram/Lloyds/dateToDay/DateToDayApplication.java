package com.Khurram.Lloyds.dateToDay;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class DateToDayApplication {
    private static final String[] belowTen = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] belowTwenty = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] belowSixty = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty"};

    public static void main(String[] args) {
        SpringApplication.run(DateToDayApplication.class, args);

        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String dateString = dateFormat.format(new Date()).toString();
        if (args.length != 0) {
            dateString = args[0];
        }
        //String for manual time check
        //dateString = "23:30";
        System.out.println(convertToHumanClock(dateString));
    }

    public static String convertToHumanClock(String dateString) {
        String TimeHourPattern =
                "([01]?[0-9]|2[0-3]):[0-5][0-9]";
        Pattern pattern = Pattern.compile(TimeHourPattern);
        Matcher matcher = pattern.matcher(dateString);

        if (matcher.matches() == false) {
            DateFormat dateFormat = new SimpleDateFormat("HH:mm");
            String time = dateFormat.format(new Date()).toString();
            dateString = time;
        }

        String result = LocalTime.parse(dateString, DateTimeFormatter.ofPattern("HH:mm")).format(DateTimeFormatter.ofPattern("hh:mm"));
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

        return englishTime;
    }

    public static String numberToWords(int num) {
        if (num == 0) return "Zero";
        if (num == 60) return "Sixty";
        return timeConverter(num);
    }

    private static String timeConverter(int num) {
        String result = new String();
        if (num < 10) result = belowTen[num];
        else if (num < 20) result = belowTwenty[num - 10];
        else if (num < 60) result = belowSixty[num / 10] + " " + timeConverter(num % 10).toLowerCase();
        return result.trim();
    }
}


