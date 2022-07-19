package org.example;

import java.util.Iterator;

/**
 * Hello world!
 *
 */
public class InnerClassDemoApp
{
    public static void main( String[] args )
    {

        System.out.println( "Inner Class Demo App:" ); //out belongs to class vs instance
        System.out.println("------------------------");

        //default constructor w capacity of 10
        MyCustomDataStructure ds = new MyCustomDataStructure(3);

        ds.add("Stackroute");
        ds.add("Stackroute");

        System.out.println(ds.size());

        Iterator<String> iter = ds.iterator();
//        System.out.println(iter.hasNext());
//        while(iter.hasNext()){
//            System.out.println(iter.next());
//        }
//
//        System.out.println(iter.hasNext());
//        iter.next(); // nosuch element exception
        ds.add("CGI");//concurrent mod exception
        iter.next();

    }
}

//better manage code/organization of classes
    //--> class will be used only for a particular class
    //--> class requires extensive access to data of another class
    //--> instantiate class only once, create as anon inner class -- comparator
    //(could create as sep class but creates unnecessary dependencies or vulnerabilities == fragile)

//Nested Class Types
/*
inner or nested classes
-- Member Inner classes (variables/properties, methods, now nested class)
-- static Inner class
-- Method Local Inner Classes (define class inside method itself, instantiated within method)
-- Anonymous Class (class with no name, instantiated once, used once)
   -(code as data using anon class, functional programming)
   -creating a class is costly, anon class is less so(less memory/steps)


sort(list, new comparator obj)
ie sort(list, new )
 */
/*
square(); (usually pass data to this method) sometime pass code as data thru anon class
 */

//SOLID Principles allow better oop
/*
--> provide solution for recurring programming problems
--> standard solution for oop

1. closed for modification open for extension (class for single purpose)
    (collection stores and processes data, shouldn't be responsible to iterate itself,
    this logic should be in separate class, but needs extensive access to data)

 */

/*
assigning value to properties there are two ways:

--use setter method or constructor itself to initialize custom values for multiple properties at same time

 */

//NONSTATIC INNER CLASS EX
//instantiating a non-static member inner class using out class instance
/*
public class InnerClassDemoApp
{
    public static void main( String[] args )
    {

        System.out.println( "Inner Class Demo App:" );
        System.out.println("------------------------");

        //instantiate outer class
        OuterClass outer = new OuterClass(); //uses blank constructor
        //VS---OuterClass outer = new OuterClass(100); uses the constructor which assigns upon instantiation
        //outer.outerShow();

        //must use outerclass obj to instantiate the new inner class
        OuterClass.InnerClass inner = outer.new InnerClass();
        outer.setOuterClassProperty(45); //initally instantiated with default int value 0
        inner.setInnerClassProperty(66);

        inner.innerShow();
    }
}
 */

//STATIC INNER CLASS EX
//instantiating static inner class without outer class instance
/*
public class InnerClassDemoApp
{
    public static void main( String[] args )
    {

        System.out.println( "Inner Class Demo App:" ); //out belongs to class vs instance
        System.out.println("------------------------");

        //instantiating a member inner class

        //instantiate inner class without instantiating outer class obj bc inner is now static, belongs to class vs belonging to instance
        OuterClass.InnerClass inner = new OuterClass.InnerClass();
        //outer.setOuterClassProperty(45); //initally instantiated with default int value 0
        inner.setInnerClassProperty(66);

        inner.innerShow();
    }
}
 */