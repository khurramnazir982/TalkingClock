package com.Khurram.Lloyds.dateToDay;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DateToDayApplicationTests {

    //Spring context test
    @Test
    void contextLoads() {
    }

    //Test 1 from Llyods Spec - 01:00 - One o'clock - Passed
    @Test
    void T0100ShouldEqualOneoclock() {
        assertEquals("One o'clock", DateToDayApplication.convertToHumanClock("01:00"));
    }

    //Test 2 from Llyods Spec - 02:00 - Two o'clock - Passed
    @Test
    void T0200ShouldEqualTwooclock() {
        assertEquals("Two o'clock", DateToDayApplication.convertToHumanClock("02:00"));
    }

    //Test 3 from Llyods Spec - 13:00 - One o'clock - Passed
    @Test
    void T1300ShouldEqualOneoclock() {
        assertEquals("One o'clock", DateToDayApplication.convertToHumanClock("13:00"));
    }

    //Test 4 from Llyods Spec - 13:05 - Five past one - Passed
    @Test
    void T1305ShouldEqualFivepastone() {
        assertEquals("Five past one", DateToDayApplication.convertToHumanClock("13:05"));
    }

    //Test 5 from Llyods Spec - 13:10 - Ten past one - Passed
    @Test
    void T1310ShouldEqualTenpastone() {
        assertEquals("Ten past one", DateToDayApplication.convertToHumanClock("13:10"));
    }

    //Test 6 from Llyods Spec - 13:25 - Twenty five past one - Passed
    @Test
    void T1325ShouldEqualTwentyfivenpastone() {
        assertEquals("Twenty five past one", DateToDayApplication.convertToHumanClock("13:25"));
    }

    //Test 7 from Llyods Spec - 13:30 - Half past one - Passed
    @Test
    void T1330ShouldEqualHalfpastone() {
        assertEquals("Half past one", DateToDayApplication.convertToHumanClock("13:30"));
    }

    //Test 8 from Llyods Spec - 13:35 - Twenty five to two - Passed
    @Test
    void T1335ShouldEqualTwentyfivetotwo() {
        assertEquals("Twenty five to two", DateToDayApplication.convertToHumanClock("13:35"));
    }

    //Test 9 from Llyods Spec - 13:55 - Five to two - Passed
    @Test
    void T1355ShouldEqualFivetotwo() {
        assertEquals("Five to two", DateToDayApplication.convertToHumanClock("13:55"));
    }

    //Test 10 from Llyods Spec - 16:30 - Half past four - Passed
    @Test
    void T1630ShouldEqualHalfpastfour() {
        assertEquals("Half past four", DateToDayApplication.convertToHumanClock("16:30"));
    }

    //Test 11 from Lloyds Spec
    //Rest API Get call test - 12:00 - Twelve o'clock - Passed
    @Test
    void doesGetWork1200ShouldEqualTwelveoclock() {
        var humanClock = new HumanClockController().humanClock("12:00");
        assertEquals("Twelve o'clock", humanClock.getHumanClockTime());
    }

    //Since the code is identical, we can assume that the
    // different time tests will work on the HumanClockController class as well.


    //Personal tests to test functionality
    //PT1 - 12:00 - Twelve o'clock - Passed
    @Test
    void T1200ShouldEqualTwelveoclock() {
        assertEquals("Twelve o'clock", DateToDayApplication.convertToHumanClock("12:00"));
    }

    //PT2 - 12:15 - Quarter past twelve - Passed
    @Test
    void T1215ShouldEqualQuarterpasttwelve() {
        assertEquals("Quarter past twelve", DateToDayApplication.convertToHumanClock("12:15"));
    }

    //PT3 - 12:45 - Quarter to one - Passed
    @Test
    void T1245ShouldEqualQuartertoone() {
        assertEquals("Quarter to one", DateToDayApplication.convertToHumanClock("12:45"));
    }

    //PT4 - 12:55 - Five to one - Passed
    @Test
    void T1255ShouldEqualFivetoone() {
        assertEquals("Five to one", DateToDayApplication.convertToHumanClock("12:55"));
    }
    //PT5 - 23:45 - Quarter to twelve - Passed
    @Test
    void T2345ShouldEqualQuartertotwelve() {
        assertEquals("Quarter to twelve", DateToDayApplication.convertToHumanClock("23:45"));
    }

    //Exception handling is done via a regex match to time, so in case of wrong input, default system time is printed.
    //To test, uncomment code and add the current time in the correct format.

    //PT6 - "time" - Twenty eight to twelve - Passed
//    @Test
//    void timehouldEqualTwentyninetotwelve() {
//        assertEquals("Twenty eight to twelve", DateToDayApplication.convertToHumanClock("time"));
//    }
//
//    //PT7 - 11:345 - Twenty six to twelve - Passed
//    @Test
//    void T11345houldEqualTwentysixtotwelve() {
//        assertEquals("Twenty six to twelve", DateToDayApplication.convertToHumanClock("11:345"));
//    }

    //This test has passed and does only work when the default time is added in to the time.
    //To try this test, please take a look at the structure of time and change the assertEquals statement on line 115.

    //System default time 07:03 - Three past seven - Passed
//    @Test
//    void TDefaultTime0703ShouldEqualThreepastseven() {
//        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
//        String dateString = dateFormat.format(new Date()).toString();
//        assertEquals("Three past seven", DateToDayApplication.humanClock(dateString));
//    }

}
