package org.example;

@FunctionalInterface
//can only contain one abstract method
//can have any number of default or static methods
public interface MyFunctionalMathInterface<T, U, V> {
    //for generics it should be single uppercase letter

    T process(U a, V b);

    //default implementation to use or override
    default public void display(){
        System.out.println("Display Method in Interface");
    }

}

//NON-GENERIC FUNCTIONAL INTERFACE
/*
@FunctionalInterface
//can only contain one abstract method
//can have any number of default or static methods
public interface MyFunctionalMathInterface {

    //int process(int a);single lambda with no () or {}
    int process(int a, int b); //for addition ex in java8demo

}
 */

//-----VS-------------------------------------------

//GENERIC
/*
package org.example;

@FunctionalInterface
//can only contain one abstract method
//can have any number of default or static methods
public interface MyFunctionalMathInterface<T, U, V> {
    //for generics it should be single uppercase letter

    T process(U a, V b);

}
 */