package org.example.java8steamdemo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//1. generate stream from scratch using static method from stream class
    //create from array or from scratch
//2. apply intermediate and terminal operations -- explore methods in Stream class
//3. work with collect / Collectors (aggregate, grouping, reduce, accum using collector lambda expressions) -- methods from Collectors class

public class StreamDemoApp {

    public static void main(String[] args)
    {
        System.out.println("Java 8 Stream");

        //sum of squares of even numbers only
        //filter odd values out
        //find the square of each even value present in filtered stream
        //reduce the value into single value, sum of all quared values
        List<Integer> intList = List.of(9,9,11,4,2, 2, 2,3,5,6);

        List<String> stringList = List.of("banana" ,"apple","lemon","apple", "Grape", "avocado", "grape");

        List<Employee> empList = List.of(
                new Employee(100, "bob", 30000, "nyc"),
                new Employee(200, "tim", 30000, "toronto"),
                new Employee(300, "jim", 45000, "boston"),
                new Employee(400, "shel", 45000, "pitts"),
                new Employee(500, "kim", 55000, "nyc")
        );

        //predicate (input and outputs boolean)
        //resulting stream contains value where predicate is true only
        //filter is intermediate, {2,4,6} --> want to map squares {4, 16,36}
        //.map takes in function lambda (takes in one input and returns one output (function is abstract method))
        //map is also intermediate operation
        //after we map, we want to reduce to sum
        //reduce takes in intial value, then pass in lambda of BiFunction (two arguments and returns one arg
        //x is accumulator, 0
        //y is each value, ie 4, 16, 32
        //0+4
        //4+16
        //20+36
        //Integer result = intList.stream().filter(x->x%2==0).map(x->x*x).reduce(0,(x,y)->x+y);
        //long result = intList.stream().filter(x->x%2==0).map(x->x*x).count();
        //optional may contain null
        //Optional result = intList.stream().filter(x->x%2==0).map(x->x*x).min(Integer::compare);

        //based on naturtal order of integer, it will return first {4, 16, 36} natural order for integer min = 4
        //natural order for integer max = 36
        //Optional<Integer> optional = intList.stream().filter(x->x%2==0).map(x->x*x).min(Integer::compare);


        //map takes to functions to key and to value
        //string will be key itself
        //Map<String, Integer> stringLengthMap = stringList.stream().distinct().collect(Collectors.toMap(x->x, x->x.length()));
        //System.out.println(stringLengthMap);

//        Map<Integer, List<Employee>> mappedByCity = empList.stream().collect(Collectors.groupingBy(x->x.getSalary()));
//        System.out.println(mappedByCity);

        Stream<Stream<Integer>> streamStream = Stream.of(
                Stream.of(2,3),
                Stream.of(4,5,6)
        );
        //first function tells us how we want to group by with lambda, second method tells us how to transform value we are
        //Map<String, Set<Stream<String>>> salaryGrouping = empList.stream().collect(Collectors.groupingBy(x->x.getCity(), Collectors.mapping(x-> Stream.of(x.getFname()),Collectors.toSet())));
        //System.out.println(salaryGrouping);

        List<Integer> stringListFromStream = stringList.stream().map(x->x.length()).collect(Collectors.toList());
        //List<String> fruityStream = stringList.stream().map(x->x.toLowerCase()).collect(Collectors.toList());
        List<String> fruityStream = stringList.stream().collect(Collectors.mapping(x->x.toLowerCase(), Collectors.toList()));
        List<String> finalFruityStream = fruityStream.stream().distinct().collect(Collectors.toList());
        //System.out.println(finalFruityStream);

        Map<String, List<Employee>> salaryGrouping = empList.stream().collect(Collectors.groupingBy(x->x.getCity(), Collectors.toList()));
        System.out.println(salaryGrouping);
    }
}

//Lambda vs method ref
/*
package org.example.java8steamdemo;

import java.util.stream.Stream;

public class StreamDemoApp {

    public static void main(String[] args)
    {
        System.out.println("Java 8 Stream");

        //using static method to create a stream
        Stream<Integer> intStream = Stream.of(2,3,4,5,6);

        //take in lambda expression of consumer, do something return nothing
        intStream.forEach(x->{
            System.out.println(x);
        });

        //vs method referencing, each item just printing
        intStream.forEach(System.out::println);
    }
}
 */

//Parallel vs not
/*
package org.example.java8steamdemo;

import java.util.stream.Stream;

public class StreamDemoApp {

    public static void main(String[] args)
    {
        System.out.println("Java 8 Stream");

        //using static method to create a stream
        Stream<Integer> intStream = Stream.of(2,3,4,5,6);

        //method referencing, each item just printing
        intStream.forEach(System.out::println);

        //parallel process outputs out of order
        intStream.parallel().forEach((System.out::println));
    }
}
 */

//performs intermediate (distinct) then terminal (foreach)
/*
package org.example.java8steamdemo;

import java.util.stream.Stream;

public class StreamDemoApp {

    public static void main(String[] args)
    {
        System.out.println("Java 8 Stream");

        //using static method to create a stream
        Stream<Integer> intStream = Stream.of(2,3, 3, 3, 5, 5, 54,5,6);

        //distinct takes in stream, returns new stream w no duplicates
        intStream.distinct().forEach((System.out::println));
        //this terminal operation consumes stream, so we cannot further operate on this speicifc stream, we'd have to get a new one
    }
}
 */

//two intermediate with final for each terminal
/*
package org.example.java8steamdemo;

import java.util.stream.Stream;

public class StreamDemoApp {

    public static void main(String[] args)
    {
        System.out.println("Java 8 Stream");

        //using static method to create a stream
        Stream<Integer> intStream = Stream.of(2,3, 3, 3, 5, 5, 54,5,6);

        //distinct takes in stream, returns new stream w no duplicates
        //before applying distinct, we are trying to print out the ints
        //must have terminal operation to conclude pipeline
        //so we apply foreach which is terminal
        //each print out does so simultaneously as it goes through each elemnt
        intStream.peek(x->{
            System.out.println("--> PEEK: " + x);
        }).distinct().forEach(System.out::println);
    }
}
 */

//static vs collection vs.intStream
/*
        List<Integer> intList = List.of(2,3, 3, 3, 5, 5, 54,5,6);
        Stream<Integer> intStreamFromIntCollection = intList.stream();
        //OR------------------
        //Arrays.stream(intList);
        //IntStream intStream = IntStream.range(1,5); //up to before 5
        //IntStream intStream = IntStream.rangeClosed(1,5); //includes 5
        //IntStream intStream = IntStream.generate(()->{return 10;}).limit(10); 10 10's
        IntStream intStream = IntStream.generate(()->{return (int)(Math.random() * 100);}).limit(20);
 */

//sum of squares of even numbers only
    //'normal way' --> for loop, sum element, if statement
    /*
    package org.example.java8steamdemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemoApp {

    public static void main(String[] args)
    {
        System.out.println("Java 8 Stream");

        //sum of squares of even numbers only
        List<Integer> intList = List.of(2,3,4,5,6);
        int sum = 0;
        (int sum is sideeffect)
        for(Integer value: intList){
           if(value%2 == 0){
               sum = sum + value*value;
           }
        }

        System.out.println(sum);

    }
}
     */
    //uses stream pipelines
    /*
            System.out.println("Java 8 Stream");

        //sum of squares of even numbers only
        //filter odd values out
        //find the square of each even value present in filtered stream
        //reduce the value into single value, sum of all quared values
        List<Integer> intList = List.of(2,3,4,5,6,9,9,11);

        //predicate (input and outputs boolean)
        //resulting stream contains value where predicate is true only
        //filter is intermediate, {2,4,6} --> want to map squares {4, 16,36}
        //.map takes in function lambda (takes in one input and returns one output (function is abstract method))
        //map is also intermediate operation
        //after we map, we want to reduce to sum
        //reduce takes in intial value, then pass in lambda of BiFunction (two arguments and returns one arg
        //x is accumulator, 0
        //y is each value, ie 4, 16, 32
        //0+4
        //4+16
        //20+36
        Integer result = intList.stream().filter(x->x%2==0).map(x->x*x).reduce(0,(x,y)->x+y);

        System.out.println(result);
     */
    //looks at min max and optional
    /*
            //Integer result = intList.stream().filter(x->x%2==0).map(x->x*x).reduce(0,(x,y)->x+y);
        //long result = intList.stream().filter(x->x%2==0).map(x->x*x).count();
        //optional may contain null
        Optional result = intList.stream().filter(x->x%2==0).map(x->x*x).min(Integer::compare);

        //based on naturtal order of integer, it will return first {4, 16, 36} natural order for integer min = 4
        //natural order for integer max = 36
        Optional<Integer> optional = intList.stream().filter(x->x%2==0).map(x->x*x).min(Integer::compare);
        System.out.println(optional.get());
     */
    //--------------------------------------------------
    //!!!!COLLECT/COLLECTOR EXAMPLE!!!!
    //(LIST)
    /*
        //takes lambda expression of type collector (reps agg operations)
        //collector is functional interface w sample implementations provided by java itself
        //collect performs reductions/min/max
        //collect result back to collection
        //Collectors. as static method to access implememntations to enact from
        List<Integer> result = intList.stream().filter(x->x%2==0).map(x->x*x).collect(Collectors.toList());
        result.forEach(System.out::println);
     */
    //(SET) sets automatically do not allow duplicates
    /*
            //takes lambda expression of type collector (reps agg operations)
        //collector is functional interface w sample implementations provided by java itself
        //collect performs reductions/min/max
        //collect result back to collection
        //Collectors. as static method to access implememntations to enact from
        Set<Integer> result = intList.stream().filter(x->x%2==0).map(x->x*x).collect(Collectors.toSet());
        result.forEach(System.out::println);
     */

//TOMAP METHOD takes two methods, lambda expressions of type Function
/*
   //map takes to functions to key and to value
        //string will be key itself
        Map<String, Integer> stringLengthMap = stringList.stream().distinct().collect(Collectors.toMap(x->x, x->x.length()));
        System.out.println(stringLengthMap);
 */

//String list distint and sorted
//stringList.stream().distinct().sorted().forEach(System.out::println);

//COLLECT EXAMPLES
/*
        //map takes to functions to key and to value
        //string will be key itself
        //Map<String, Integer> stringLengthMap = stringList.stream().distinct().collect(Collectors.toMap(x->x, x->x.length()));
        //System.out.println(stringLengthMap);

        Integer listSum = intList.stream().filter(x->x%2==0).map(x->x*x).collect(Collectors.summingInt(x->x));
        System.out.println(listSum);

        long count = intList.stream().filter(x->x%2==0).map(x->x*x).collect(Collectors.counting());
        System.out.println(count);
 */
//MAP of int and list of strings as value
/*
        //group of lists which take length as key, and a list of strings having that length
        //{5=[apple, lemon, apple, Grape], 6=[banana], 7=[avocado]}
        Map<Integer, List<String>> groupByLength = stringList.stream().collect(Collectors.groupingBy(x->x.length()));
        System.out.println(groupByLength);
        //System.out.println(result.get());
 */

//EMPLOYEE CLASS EXAMPLE
/*
        List<Employee> empList = List.of(
                new Employee(100, "bob", 30000, "nyc"),
                new Employee(200, "tim", 30000, "toronto"),
                new Employee(300, "jim", 45000, "boston"),
                new Employee(400, "shel", 45000, "pitts"),
                new Employee(500, "kim", 55000, "nyc")
        );

        empList.stream().forEach(System.out::println);

--------//mapping string key to list of employees matching that city
        Map<String, List<Employee>> mappedByCity = empList.stream().collect(Collectors.groupingBy(x->x.getCity()));
        System.out.println(mappedByCity);

--------//mapping integer key to list of employee objs
        Map<Integer, List<Employee>> mappedByCity = empList.stream().collect(Collectors.groupingBy(x->x.getSalary()));
        System.out.println(mappedByCity);
 */

//FLATMAP
/*
        Stream<Stream<Integer>> streamStream = Stream.of(
                Stream.of(2,3),
                Stream.of(4,5,6)
        );

        //followoing returns 2
        //long streamCount = streamStream.count();
        //System.out.println(streamCount);

        //vs
        long streamCOunt = streamStream.flatMap(x->x).count();
        System.out.println(streamCOunt);
       // streamStream.flatMap(x->x).forEach(System.out::println);
 */


//more mapping converting one data type to another, ie whole emp object to emp obj string name
/*
    public static void main(String[] args)
    {
        System.out.println("Java 8 Stream");

        //sum of squares of even numbers only
        //filter odd values out
        //find the square of each even value present in filtered stream
        //reduce the value into single value, sum of all quared values
        List<Integer> intList = List.of(9,9,11,4,2, 2, 2,3,5,6);

        List<String> stringList = List.of("banana" ,"apple","lemon","apple", "Grape", "avocado");

        List<Employee> empList = List.of(
                new Employee(100, "bob", 30000, "nyc"),
                new Employee(200, "tim", 30000, "toronto"),
                new Employee(300, "jim", 45000, "boston"),
                new Employee(400, "shel", 45000, "pitts"),
                new Employee(500, "kim", 55000, "nyc")
        );

        //predicate (input and outputs boolean)
        //resulting stream contains value where predicate is true only
        //filter is intermediate, {2,4,6} --> want to map squares {4, 16,36}
        //.map takes in function lambda (takes in one input and returns one output (function is abstract method))
        //map is also intermediate operation
        //after we map, we want to reduce to sum
        //reduce takes in intial value, then pass in lambda of BiFunction (two arguments and returns one arg
        //x is accumulator, 0
        //y is each value, ie 4, 16, 32
        //0+4
        //4+16
        //20+36
        //Integer result = intList.stream().filter(x->x%2==0).map(x->x*x).reduce(0,(x,y)->x+y);
        //long result = intList.stream().filter(x->x%2==0).map(x->x*x).count();
        //optional may contain null
        //Optional result = intList.stream().filter(x->x%2==0).map(x->x*x).min(Integer::compare);

        //based on naturtal order of integer, it will return first {4, 16, 36} natural order for integer min = 4
        //natural order for integer max = 36
        //Optional<Integer> optional = intList.stream().filter(x->x%2==0).map(x->x*x).min(Integer::compare);


        //map takes to functions to key and to value
        //string will be key itself
        //Map<String, Integer> stringLengthMap = stringList.stream().distinct().collect(Collectors.toMap(x->x, x->x.length()));
        //System.out.println(stringLengthMap);

//        Map<Integer, List<Employee>> mappedByCity = empList.stream().collect(Collectors.groupingBy(x->x.getSalary()));
//        System.out.println(mappedByCity);

        Stream<Stream<Integer>> streamStream = Stream.of(
                Stream.of(2,3),
                Stream.of(4,5,6)
        );

        //collect result back into collection set, only collecting id so we map each obj to its own id integer
        Set<Integer> empSet = empList.stream().collect(Collectors.mapping(x->x.getId(),Collectors.toSet()));
        System.out.println(empSet);
    }
}
 */
/*
        //first function tells us how we want to group by with lambda, second method tells us how to transform value we are
        Map<Integer, Set<Employee>> salaryGrouping = empList.stream().collect(Collectors.groupingBy(x->x.getSalary(), Collectors.toSet()));
        System.out.println(salaryGrouping);

        //first function tells us how we want to group by with lambda, second method tells us how to transform value we are
        here we are collecting the count of objects in that list
        Map<Integer, Long> salaryGrouping = empList.stream().collect(Collectors.groupingBy(x->x.getSalary(), Collectors.counting()));
        System.out.println(salaryGrouping);

        Map<Integer, Integer> salaryGrouping = empList.stream().collect(Collectors.groupingBy(x->x.getSalary(), Collectors.summingInt(x->x.getSalary())));
        System.out.println(salaryGrouping);
        {30000=60000, 55000=55000, 45000=90000}

    *** Map<String, Integer> salaryGrouping = empList.stream().collect(Collectors.groupingBy(x->x.getCity(), Collectors.summingInt(x->x.getSalary())));
        System.out.println(salaryGrouping);
        {boston=45000, pitts=45000, toronto=30000, nyc=85000}
        total salaries of all emps working in each city

    ****Map<String, Set<String>> salaryGrouping = empList.stream().collect(Collectors.groupingBy(x->x.getCity(), Collectors.mapping(x-> x.getFname(),Collectors.toSet())));
        System.out.println(salaryGrouping);
        {boston=[jim], pitts=[shel], toronto=[tim], nyc=[bob, kim]}
 */

//multistream mapping
/*
        Map<String, Set<Stream<String>>> salaryGrouping = empList.stream().collect(Collectors.groupingBy(x->x.getCity(), Collectors.mapping(x-> Stream.of(x.getFname()),Collectors.toSet())));
        System.out.println(salaryGrouping);

**Fruits**List<Integer> stringListFromStream = stringList.stream().map(x->x.length()).collect(Collectors.toList());
        System.out.println(stringListFromStream);
 */

//---------------FRUIT EXAMPLE-------------
/*
     List<String> fruityStream = stringList.stream().collect(Collectors.mapping(x->x.toLowerCase(), Collectors.toList()));
        List<String> finalFruityStream = fruityStream.stream().distinct().collect(Collectors.toList());
        System.out.println(finalFruityStream);

        from List<String> stringList = List.of("banana" ,"apple","lemon","apple", "Grape", "avocado", "grape");
to this below-->
        [banana, apple, lemon, grape, avocado]
 */