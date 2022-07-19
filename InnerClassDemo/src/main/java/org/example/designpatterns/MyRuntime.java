package org.example.designpatterns;
//singleton design pattern
//approach already implemented many times, proved to be valid
//and follow SOLID principles
public class MyRuntime {

    //private constructor prevents external models from instantiating outside of the class,
    //now globally its instance can be referenced, all back to same ref point
    private MyRuntime(){}

    //prevent from  getting updated to another instance (final)
    private static final MyRuntime myRuntime = new MyRuntime();

    public void printDetails(){
        System.out.println("Details of Runtime");
    }

    //this returns the final instance, it is static so that it can be called on globally, without external instantiation
    public static MyRuntime getMyRuntime(){
        return myRuntime;
    }
}
