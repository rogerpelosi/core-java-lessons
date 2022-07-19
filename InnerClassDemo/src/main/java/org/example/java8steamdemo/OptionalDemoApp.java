package org.example.java8steamdemo;

import javax.swing.text.html.Option;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalDemoApp {

    //Optional is a container for objects that many contain null
    //mandates us to perform a null check

    public static void main(String[] args)
    {
        System.out.println("Optional Demo App");
        System.out.println("------------------");

        //Optional<String> opt = getName();


        System.out.println(getName());

        //opt.ifPresent(System.out::println);
    }

    public static String getName(){
        String name = "null";
        return Optional.ofNullable(name).orElse("hehe");
    }

}

//NPE
/*
    public static void main(String[] args)
    {
        System.out.println("Optional Demo App");
        System.out.println("------------------");

        String name = getName();

        //if getName returns null, it will fail
        //either need to try catch, add to throws list, add a check
        System.out.println(name.length());
    }

    public static String getName(){
        return null;
    }
 */
//MANUAL CONDITION BLOCK
/*
    public static void main(String[] args)
    {
        System.out.println("Optional Demo App");
        System.out.println("------------------");

        String name = getName();

        if(name != null){
            System.out.println(name.length());
        } else {
            System.out.println("Invalid Name");
        }

    }

    public static String getName(){
        return null;
    }
 */

//-------------------------
//OPTIONAL INTRO
/*
    public static void main(String[] args)
    {
        System.out.println("Optional Demo App");
        System.out.println("------------------");

        String name = "null";
        Optional<String> opt = Optional.ofNullable(name);

        System.out.println(opt.isEmpty());
        System.out.println(opt.isPresent());
    }
    VS----------------------
        public static void main(String[] args)
    {
        System.out.println("Optional Demo App");
        System.out.println("------------------");

        String name = null; <-------------------
        Optional<String> opt = Optional.ofNullable(name);

        System.out.println(opt.isEmpty());
        System.out.println(opt.isPresent());
    }
 */
//ENTIRE Optional via public static
/*
public class OptionalDemoApp {

    //Optional is a container for objects that many contain null
    //mandates us to perform a null check

    public static void main(String[] args)
    {
        System.out.println("Optional Demo App");
        System.out.println("------------------");

        Optional<String> opt = getName();
        if(opt.isPresent()){
            //if present, then getting actual string from opt and finding length
            System.out.println(opt.get().length());
        } else{
            System.out.println("Failed to find valid String");
        }
    }

    public static Optional<String> getName(){
        String name = "String";
        return Optional.ofNullable(name);
    }

}
 */
//filter optional with predicate
/*
public class OptionalDemoApp {

    public static void main(String[] args)
    {
        System.out.println("Optional Demo App");
        System.out.println("------------------");

        Optional<String> opt = getName();
        if(opt.isPresent()){
            //if present, then getting actual string from opt and finding length
            System.out.println(opt.get().length());
        } else{
            System.out.println("Failed to find valid String");
        }
    }

    public static Optional<String> getName(){
        String name = "Stringgggggggggggg";
        return Optional.ofNullable(name).filter(x->x.length()<10);
    }

}
 */
//map
/*
map new value as welcome
--if value present it will map, else return empty optional
    public static Optional<String> getName(){
        String name = "string";
        return Optional.ofNullable(name).map(x->"welcome");
    }
 */

//declarative reformatting
/*
    public static void main(String[] args)
    {
        System.out.println("Optional Demo App");
        System.out.println("------------------");

        Optional<String> opt = getName();
        if(opt.isPresent()){
            //if present, then getting actual string from opt and finding length
            System.out.println(opt.get());
        }
        else{
            System.out.println("Failed to find valid String");
        }
    }

    public static Optional<String> getName(){
        String name = "string";
        return Optional.ofNullable(name).map(x->"welcome"+name);
    }

}

---------------------------------------------------------------
    public static void main(String[] args)
    {
        System.out.println("Optional Demo App");
        System.out.println("------------------");

        Optional<String> opt = getName();

        opt.ifPresent(System.out::println);
    }

    public static Optional<String> getName(){
        String name = "string";
        return Optional.ofNullable(name).map(x->"welcome"+name);
    }

}
 */

//orelsethrow
/*
    public static void main(String[] args)
    {
        System.out.println("Optional Demo App");
        System.out.println("------------------");

        //Optional<String> opt = getName();

        try{System.out.println(getName());}catch(NoSuchElementException e){
            System.out.println(e);
    }

        //opt.ifPresent(System.out::println);
    }

    public static String getName(){
        String name = null;
        return Optional.ofNullable(name).orElseThrow();
    }

}
 */
//orelse
/*
    public static void main(String[] args)
    {
        System.out.println("Optional Demo App");
        System.out.println("------------------");

        //Optional<String> opt = getName();


        System.out.println(getName());

        //opt.ifPresent(System.out::println);
    }

    public static String getName(){
        String name = null;
        return Optional.ofNullable(name).orElse("hehe");
    }
 */


//BASICS OF LESSON LEARNED______________________________________
    //create optional using ofnullable and empty
    //check if value is present in optional using isempty() ispresent()
    //getting the val/obj from optional get()
    //applying filter and mape to optional
    //throwing exceptionusing orelsethrow
    //returning alt value using orelse
    //performing operation in declarative way using ifpresent()