package com.Khurram.Lloyds.dateToDay;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class HumanClockController {

    @GetMapping("/humanclock")
    public HumanClock humanClock(@RequestParam(value = "time", defaultValue = "default") String time) {

        String TimeHourPattern =
                "([01]?[0-9]|2[0-3]):[0-5][0-9]";
        Pattern pattern = Pattern.compile(TimeHourPattern);
        Matcher matcher = pattern.matcher(time);

        if (matcher.matches() == false) {
                DateFormat dateFormat = new SimpleDateFormat("HH:mm");
                String dateString = dateFormat.format(new Date()).toString();
                time = dateString;
        }
        return new HumanClock(time);
    }

}
