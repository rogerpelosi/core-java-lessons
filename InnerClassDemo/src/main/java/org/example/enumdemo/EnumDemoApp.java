package org.example.enumdemo;

/*
+used to represent a type that has finite values
+group of constants

+Weekdays --> Sunday,.....,Saturday
+Months --> January,......,December
+Seasons, Card Deck, etc.
 */

import org.example.enumdemo.Month;

public class EnumDemoApp {
    public static void main(String[] args)
    {
        System.out.println("Enum Demo App");
        System.out.println("^^^^^^^^^^^^^");

        for(Month month:Month.values()){
            System.out.println(month.getValue());
        }

    }
}

//Basic Month Enum Example
/*
    public static void main(String[] args)
    {
        System.out.println("Enum Demo App");
        System.out.println("^^^^^^^^^^^^^");

        //not all strings here are valid, ie "Poop" is not a month
        //String month = "January";

        //create separate type using enum
        //Enum name itself, followed by value
        Month month = Month.JANUARY;
        System.out.println(month);
    }

    --CONSOLE--
Enum Demo App
^^^^^^^^^^^^^
JANUARY
 */
