package org.example.enumdemo;

public enum Month {
    //the following are static members of type enum (Month in this case)
    JANUARY(1),FEBRUARY(2),MARCH(3),APRIL(4),MAY(5);

    private int value;

    //override constructor (either can be default or private)
    //doinng this to associate a value with each month, ie jan is usually recognized as month 1, dec month 12
    Month(int value){
        this.value = value;
    }

    public void show() {
        System.out.println("Show Method in Enum, Month");
    }

    public int getValue(){
        return this.value;
    }
}
//Internally java will create a class called month, see internal process below
/*
public class Month{
    public static final JANUARY = new Month();
    public static final FEBRUARY = new Month();
    public static final MARCH = new Month();
    public static final APRIL = new Month();
    public static final MAY = new Month();

    private Month(){}
    (constructor is made private, only invoked within this class)
}
 */

//Regular Expression -- Support for this provided in package Regex
//Regular Expressions --> search patterns
//Search Patterns allow us to validate a set of strings

//Regex Example
/*
yyyy/mm/dd --> search pattern acts a rule for following strings

1987/08/11
2021/08/23
 */
