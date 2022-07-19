package org.example.timeapidemo;

/*
+here we will represent date and time (immutable representations)
    --> represented as Temporal Units
        -day
        -month
        -year
        -hour
        -minute
        -seconds
        -period
        -duration

+Chrono units-parts of date and time
+format the date and time (custom format)
+parse string as a date representation
+w/wout time zones, represent time based on ZoneOffSet

+Temporal arithmetic (simple operations we can perform with date)
    -adding/minus specific number of days/months/years/hours/min/etc to specific date

+Temporal adjusters (represents recurrent events, more complex operations)
    -FirstDayOf week, LastDayOf the year
    -date of all fridays in one month or year, etc.
 */

import javax.swing.text.DateFormatter;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TimeAPIDemoApp {

    public static void main(String[] args)
    {
        System.out.println("Time API Demo App");
        System.out.println("^^^^^^^^^^^^^^^^^");

        LocalDate today = LocalDate.now();
        //System.out.println(today.getMonth());
        System.out.println(today.getMonthValue());
        System.out.println(today.getYear());
        System.out.println(today.getDayOfYear());
        System.out.println(today.get(ChronoField.DAY_OF_YEAR));

        //temporal unit is any date or time unit
        //new date 7 days from no
        LocalDate newDate = today.plusDays(7);
        LocalDate joiningDate = LocalDate.of(2011,8,10);
        System.out.println(today);
        System.out.println(newDate);

        System.out.println("Adding Using Temporal AMount");
        System.out.println("---------------------------");
        LocalDate anotherDate = today.plus(Period.parse("P7M"));
        System.out.println(anotherDate);
        System.out.println(today);

        //finding difference between two times
        LocalTime currentTime = LocalTime.now();
        LocalTime startTime = LocalTime.of(9,30);
        Duration duration = Duration.between(startTime, currentTime);
        System.out.println(duration);

        System.out.println("FINDING DIFFERENCE USING CHRONOUNIT");
        System.out.println("-----------------------------------");

//        for(ChronoUnit unit:ChronoUnit.values()){
//            System.out.println(unit);
//        }

        System.out.println(ChronoUnit.DAYS.between(joiningDate,today));
        System.out.println(ChronoUnit.DECADES.between(joiningDate,today));
        System.out.println(ChronoUnit.MONTHS.between(joiningDate,today));

        System.out.println("Handling Recurring Events with TemporalAdjusters");
        System.out.println("--------------------------------------------");

        //DayOfWeek is an enum
        System.out.println(today.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
        System.out.println(today.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println(today.with(TemporalAdjusters.lastDayOfMonth()));

        System.out.println(today.with(t->t.plus(Period.parse("P7D"))));

        while(today.plusDays(7).isBefore(LocalDate.of(2022, 4, 30))){
            today = today.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
            System.out.println(today);
        }
    }
}

//Intro LocalDate / LocalTime / LocalDateTime
/*
    public static void main(String[] args)
    {
        System.out.println("Time API Demo App");
        System.out.println("------------------");

        //just use static method to get instance we want
        LocalDate today = LocalDate.now();
        //represent specific date using of method
        LocalDate joiningDate = LocalDate.of(2011,8,11);

        System.out.println(today);
        System.out.println(joiningDate);

        LocalTime currentTime = LocalTime.now();
        LocalTime joiningTime = LocalTime.of(9,30);

        System.out.println(currentTime);
        System.out.println(joiningTime);

        LocalDateTime todayWTime = LocalDateTime.now();
        //here we pass two variables from above
        LocalDateTime joiningDateTime = LocalDateTime.of(today, currentTime);

        System.out.println(todayWTime);
        System.out.println(joiningDateTime);

    }

    CONSOLE-----------------
    2022-04-19
    2011-08-11
    10:18:40.734776800
    09:30
    2022-04-19T10:20:41.463579400
    2022-04-19T10:22:12.481357200

 */

//Zone Ids
/*
ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);
ZoneId.getAvailableZoneIds().stream().limit(20).forEach(System.out::println);

-----PROCESS-----
Europe/London
LocalDateTime todayWTime = LocalDateTime.now(ZoneId.of("Europe/London"));
System.out.println("Europe/London " + todayWTime);
Europe/London 2022-04-19T15:27:01.091900400

{
System.out.println("Zoned Date Time");
System.out.println("---------------");

ZonedDateTime todayWZone = ZonedDateTime.now();
System.out.println(todayWZone);
}

-----CONSOLE-----
Zoned Date Time
---------------
2022-04-19T10:30:10.978308900-04:00[America/New_York]
 */

//Zone Offset
/*
System.out.println("Getting Time Using Zone Offset");
System.out.println("------------------------------");

OffsetDateTime todayUsingOffset = OffsetDateTime.now(ZoneOffset.of("+05:30"));
System.out.println(todayUsingOffset);

----CONSOLE-----
Getting Time Using Zone Offset
------------------------------
2022-04-19T20:02:51.796295100+05:30
 */

//Custom Formatting DateTimeFormatter
/*
    public static void main(String[] args)
    {
        System.out.println("Time API Demo App");
        System.out.println("------------------");

        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.out.println(formatter.format(today));
    }

   ---CONSOLE---
    2022-04-19
    20220419
 */

//Custom Formatting DateTimeFormatter Pattern
/*
    public static void main(String[] args)
    {
        System.out.println("Time API Demo App");
        System.out.println("------------------");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.out.println(formatter.format(today));
    }

    --CONSOLE--
    2022-04-19
    19/04/2022

    ======================================================
        public static void main(String[] args)
    {
        System.out.println("Time API Demo App");
        System.out.println("------------------");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy hh:mm");
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);
        System.out.println(formatter.format(today));
    }

    --CONSOLE--
    2022-04-19T10:41:51.736769400
    19/Apr/2022 10:41
 */

//Parsing LocalDate using patterned formatter
/*
    public static void main(String[] args)
    {
        System.out.println("Time API Demo App");
        System.out.println("^^^^^^^^^^^^^^^^^");

        System.out.println("Formatting DateTime using Custom Format");
        System.out.println("---------------------------------------");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.out.println(formatter.format(today));

        System.out.println("");
        System.out.println("Parsing String to DateTime Representation");
        System.out.println("------------------------------------------");
        String joiningDateTimeAsString = "11/Aug/2011";
        //from this string, I want to get local date time correspondance to string, based on patterned formatter
        LocalDate joiningDateTime = LocalDate.parse(joiningDateTimeAsString, formatter);
        System.out.println(joiningDateTime);
    }

    --CONSOLE--
    Time API Demo App
^^^^^^^^^^^^^^^^^
Formatting DateTime using Custom Format
---------------------------------------
2022-04-19
19/Apr/2022

Parsing String to DateTime Representation
------------------------------------------
2011-08-11

Process finished with exit code 0

 */

//CHRONO Field
/*
    public static void main(String[] args)
    {
        System.out.println("Time API Demo App");
        System.out.println("^^^^^^^^^^^^^^^^^");

        LocalDate today = LocalDate.now();
        System.out.println(today.getMonth());
        System.out.println(today.getMonthValue());
        System.out.println(today.getYear());
        System.out.println(today.getDayOfYear());
        System.out.println(today.get(ChronoField.DAY_OF_YEAR));
    }

    --CONSOLE--
    Time API Demo App
^^^^^^^^^^^^^^^^^
APRIL
4
2022
109
109
 */

//Simple Arithimetic
/*
    public static void main(String[] args)
    {
        System.out.println("Time API Demo App");
        System.out.println("^^^^^^^^^^^^^^^^^");

        LocalDate today = LocalDate.now();
        System.out.println(today.getMonth());
        System.out.println(today.getMonthValue());
        System.out.println(today.getYear());
        System.out.println(today.getDayOfYear());
        System.out.println(today.get(ChronoField.DAY_OF_YEAR));

        //temporal unit is any date or time unit
        //new date 7 days from no
        LocalDate newDate = today.plusDays(7);
        System.out.println(today);
        System.out.println(newDate);
    }
    --CONSOLE--
Time API Demo App
^^^^^^^^^^^^^^^^^
APRIL
4
2022
109
109
2022-04-19
2022-04-26
 */

//PERIOD -- diff between dates
//DURATION -- diff between time

//Period between
/*
    public static void main(String[] args)
    {
        System.out.println("Time API Demo App");
        System.out.println("^^^^^^^^^^^^^^^^^");

        LocalDate today = LocalDate.now();
        System.out.println(today.getMonth());
        System.out.println(today.getMonthValue());
        System.out.println(today.getYear());
        System.out.println(today.getDayOfYear());
        System.out.println(today.get(ChronoField.DAY_OF_YEAR));

        //temporal unit is any date or time unit
        //new date 7 days from no
        LocalDate newDate = today.plusDays(7);
        LocalDate joiningDate = LocalDate.of(2011,8,10);
        System.out.println(today);
        System.out.println(newDate);

        //finding difference between two dates
         Period experince = Period.between(joiningDate,  today);
        System.out.println(experince);
        System.out.println(experince.getYears());
        System.out.println(experince.getMonths());
        System.out.println(experince.getDays());
    }

    --CONSOLE--
Time API Demo App
^^^^^^^^^^^^^^^^^
APRIL
4
2022
109
109
2022-04-19
2022-04-26
P10Y8M9D
10
8
9
 */

//Duration between
/*
        //finding difference between two times
        LocalTime currentTime = LocalTime.now();
        LocalTime startTime = LocalTime.of(9,30);
        Duration duration = Duration.between(startTime, currentTime);
        System.out.println(duration);

        --CONSOLE--
        PT1H38M21.1765907S
 */

//Adding Using Temporal Amounts
/*
        //temporal unit is any date or time unit
        //new date 7 days from no
        LocalDate newDate = today.plusDays(7);
        LocalDate joiningDate = LocalDate.of(2011,8,10);
        System.out.println(today);
        System.out.println(newDate);

        System.out.println("Adding Using Temporal AMount");
        System.out.println("---------------------------");
        LocalDate anotherDate = today.plus(Period.parse("P7M"));
        System.out.println(anotherDate);
        System.out.println(today);

        --CONSOLE--

2022-04-19
2022-04-26
Adding Using Temporal AMount
---------------------------
2022-11-19
2022-04-19
 */

//Finding difference using ChronoUnit
/*
        System.out.println("FINDING DIFFERENCE USING CHRONOUNIT");
        System.out.println("-----------------------------------");

//        for(ChronoUnit unit:ChronoUnit.values()){
//            System.out.println(unit);
//        }

        System.out.println(ChronoUnit.DAYS.between(joiningDate,today));
        System.out.println(ChronoUnit.DECADES.between(joiningDate,today));
        System.out.println(ChronoUnit.MONTHS.between(joiningDate,today));
--CONSOLE--
FINDING DIFFERENCE USING CHRONOUNIT
-----------------------------------
3905
1
128
 */

//TemporalAdjuster -- TemporalAdjusters

//Temporal Adjustors (more complex)
/*
        System.out.println("Handling Recurring Events with TemporalAdjusters");
        System.out.println("--------------------------------------------");

        //DayOfWeek is an enum
        System.out.println(today.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
        System.out.println(today.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println(today.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println(today.with(t->t.plus(Period.parse("P7D"))));

        --CONSOLE--
Handling Recurring Events with TemporalAdjusters
--------------------------------------------
2022-04-22
2022-04-01
2022-04-30
2022-04-26
 */

//getting all the future friday dates in current month
/* (today is 2022-04-19 fyi)
        while(today.plusDays(7).isBefore(LocalDate.of(2022, 4, 30))){
            today = today.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
            System.out.println(today);
        }

        --CONSOLE--
2022-04-22
2022-04-29
 */