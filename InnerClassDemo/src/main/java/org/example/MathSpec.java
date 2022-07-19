package org.example;

@FunctionalInterface
public interface MathSpec {

    //specification to implement proper mathematical method
    //specify what exceptions it might throw --> create custom exception using inner class
    //if method needs to throw exception, custom or built in, we need to specify
    //throws ArithmeticException is built in one
    //vs InvalidInput is custom, so we create inner class
    int add(int a, int b);

    //formal use of inner class
    //class InvalidInputException extends Exception{}
}
