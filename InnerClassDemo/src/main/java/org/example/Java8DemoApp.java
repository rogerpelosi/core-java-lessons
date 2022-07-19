package org.example;

import java.util.List;
import java.util.function.BiFunction;

public class Java8DemoApp {

    public static void main(String[] args)
    {

        BiFunction<Integer, Integer, Integer> additionInt = Java8DemoApp::sum;

        MyFunctionalMathInterface<Double, Double, Double> additionDouble = (x,y)->x+y;
        BiFunction<Double, Double, Double> subDouble = (x,y)->x-y;

        System.out.println(additionInt.apply(1,3));
        System.out.println(additionDouble.process(12.4,5.6));
        System.out.println(subDouble.apply(12.3,5.5));

        //making method to return a lambda
        MyFunctionalMathInterface<Integer, Integer, Integer> multiplyInt = providedFuncInt();

        //INSTEAD OF THIS
        //execute((x,y)->x+y, 10, 20);//like passing a callback
        execute(Java8DemoApp::sum, 100, 200);//refers to implementation of sum that belongs to object app (method referencing)
        multiplyInt.process(2,5);

        List<Integer> intList = List.of(12, 13,14,15);

        //applied to each and every element of intList
//        intList.forEach(x->{
//            System.out.println(x);
//        });
        //------VS
        intList.forEach(System.out::println);//referring to implementation of System for each item of intlist, pass consumer object

        additionDouble.display();
    }

    //take in a lambda and 2 ints
    public static void execute(MyFunctionalMathInterface<Integer, Integer, Integer> myFunctionalMathInterface, int a, int b)
    {
        System.out.println(myFunctionalMathInterface.process(a,b));
    }

    //specifies return type as our defined lambda expression
    public static MyFunctionalMathInterface<Integer, Integer, Integer> providedFuncInt(){
        return (x,y)->x*y;
    }

    //member method of Java8DemoApp
    //made static to then refer to Java8DemoApp class and not an instance
    public static Integer sum(Integer a, Integer b){
        return a+b;
    }

}

//Java 8 features JSR-335
/*
Lambda Expressions or closures
Functional Interfaces
Method Referencing
Stream and Stream Operations

INTRODUCED AROUND JAVA 8
NIO (new input / output)
Time API
Optional (handle null in a more efficient way)

-----<Details-----
+aims to reduce bulkiness of code,
especially in passing code as an argument

+use multi threading feature for data processing
(tries to simplify process of parallel processing)

+supporting functional programming approach vs oop
(solve problem by pipelining multiple small operation)
(more small operations communicate with each other)

+Focus of functional programming = what is to be done
instead of how it is to be done
-----Details/>-----
 */

//LAMBDA EXPRESSION
/*
--------------------------------------------
+replacing anon class with an anon expression
+typically created using the Functional Interface
+if we need to create a lambda expr, the functional interf defines the type of LE
+Lambda can be assigned to a variable, passed as an argument and returned by a method

+treat like any other object, assigned to var, returned, etc.
--------------------------------------------
EXAMPLES OF SYNTAX
MyFunctionalMathInterface square = x->x*x;
MyFunctionalMathInterface addition = (x, y)->x+y;
MyFunctionalMathInterface blah = (x, y)->{x+y;}

 */
    //NON-GENERIC
    /*
package org.example;

public class Java8DemoApp {

    public static void main(String[] args)
    {
        //MyFunctionalMathInterface additon= void methodName(int a, int b){}
        //VS LAMBDA----------------------------------
//        MyFunctionalMathInterface additon = (a, b)->{
//            return a +b;
//        };
        //VS---------------
        MyFunctionalMathInterface additon = (x, y)->x+y;
        MyFunctionalMathInterface sub = (x, y)->x-y;
        MyFunctionalMathInterface muly = (x, y)->x*y;
        MyFunctionalMathInterface div = (x, y)->x/y;
        //implementation of abstract process method
        System.out.println(additon.process(1,2));
        System.out.println(sub.process(2,6.1));
        System.out.println(muly.process(5,6));
        System.out.println(div.process(8,4));
    }
}
 */
    //GENERIC
    /*
package org.example;

public class Java8DemoApp {

    public static void main(String[] args)
    {
        //MyFunctionalMathInterface additon= void methodName(int a, int b){}
        //VS LAMBDA----------------------------------
//        MyFunctionalMathInterface additon = (a, b)->{
//            return a +b;
//        };
        //VS---------------
        MyFunctionalMathInterface<Integer, Integer, Integer> additionInt = (x,y)->x+y;
        MyFunctionalMathInterface<Double, Double, Double> additionDouble = (x,y)->x+y;
        MyFunctionalMathInterface<Double, Double, Double> subDouble = (x,y)->x-y;
        //implementation of abstract process method
        System.out.println(additionInt.process(1,3));
        System.out.println(additionDouble.process(12.4,5.6));
        System.out.println(subDouble.process(12.3,5.5));

    }
}
 */
    //GENERIC WITH BUILT-IN BiFunction FUN INTERFACE
    /*
public class Java8DemoApp {

    public static void main(String[] args)
    {
        BiFunction<Integer, Integer, Integer> additionInt = (x, y)->x+y;
        BiFunction<Double, Double, Double> additionDouble = (x,y)->x+y;
        BiFunction<Double, Double, Double> subDouble = (x,y)->x-y;

        System.out.println(additionInt.apply(1,3));
        System.out.println(additionDouble.apply(12.4,5.6));
        System.out.println(subDouble.apply(12.3,5.5));

    }
}
 */
    //TAKING IN LAMBDA AS ARG | RETURN TYPE AS LAMBDA
    /*
    package org.example;

import java.util.function.BiFunction;

public class Java8DemoApp {

    public static void main(String[] args)
    {
        BiFunction<Integer, Integer, Integer> additionInt = (x, y)->x+y;
        BiFunction<Double, Double, Double> additionDouble = (x,y)->x+y;
        BiFunction<Double, Double, Double> subDouble = (x,y)->x-y;

        System.out.println(additionInt.apply(1,3));
        System.out.println(additionDouble.apply(12.4,5.6));
        System.out.println(subDouble.apply(12.3,5.5));

        //making method to return a lambda
        MyFunctionalMathInterface<Integer, Integer, Integer> multiplyInt = providedFuncInt();

        execute((x,y)->x+y, 10, 20);//like passing a callback
        multiplyInt.process(2,5);
    }

    //take in a lambda and 2 ints
    public static void execute(MyFunctionalMathInterface<Integer, Integer, Integer> myFunctionalMathInterface, int a, int b)
    {
        System.out.println(myFunctionalMathInterface.process(a,b));
    }

    //specifies return type as our defined lambda expression
    public static MyFunctionalMathInterface<Integer, Integer, Integer> providedFuncInt(){
        return (x,y)->x*y;
    }

}
     */

//FUNCTIONAL INTERFACE (some of these already exist)
/*
--------------------------------------------
+interface that is having only one abstract method
--------------------------------------------
 */

//METHOD REFERENCING
/*
package org.example;

import java.util.function.BiFunction;

public class Java8DemoApp {

    public static void main(String[] args)
    {
        Java8DemoApp app = new Java8DemoApp();

        BiFunction<Integer, Integer, Integer> additionInt = app::sum;

        BiFunction<Double, Double, Double> additionDouble = (x,y)->x+y;
        BiFunction<Double, Double, Double> subDouble = (x,y)->x-y;

        System.out.println(additionInt.apply(1,3));
        System.out.println(additionDouble.apply(12.4,5.6));
        System.out.println(subDouble.apply(12.3,5.5));

        //making method to return a lambda
        MyFunctionalMathInterface<Integer, Integer, Integer> multiplyInt = providedFuncInt();

        //INSTEAD OF THIS
        //execute((x,y)->x+y, 10, 20);//like passing a callback
        execute(app::sum, 100, 200);//refers to implementation of sum that belongs to object app (method referencing)
        multiplyInt.process(2,5);
    }

    //take in a lambda and 2 ints
    public static void execute(MyFunctionalMathInterface<Integer, Integer, Integer> myFunctionalMathInterface, int a, int b)
    {
        System.out.println(myFunctionalMathInterface.process(a,b));
    }

    //specifies return type as our defined lambda expression
    public static MyFunctionalMathInterface<Integer, Integer, Integer> providedFuncInt(){
        return (x,y)->x*y;
    }

    //member method of Java8DemoApp
    public Integer sum(Integer a, Integer b){
        return a+b;
    }

}
 */