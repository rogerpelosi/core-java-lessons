package com.stackroute;

public class MathService {

    public int square(int value){
        //default = 0
        System.out.println("Square invoked");
        return value * value;
    }

    public double square(double value){
        //default = 0.0
        return value * value;
    }
}
