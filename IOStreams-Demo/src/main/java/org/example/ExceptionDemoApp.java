package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionDemoApp {

    public static void main(String[] args) throws MovieNotFoundException{
        System.out.println("Exception Demo: ");
        System.out.println("------------------------");

        //for class extends Exception, if RuntimeException, throw not needed in main
        throw new MovieNotFoundException();

//        try {
//            methodA();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Terminated Successfully");

    }

    public static void methodA() throws FileNotFoundException {
        methodB();
    }

    public static void methodB() throws FileNotFoundException {
        methodC();
    }

    public static void methodC() throws FileNotFoundException {
        File file = new File("");
        FileInputStream fis = new FileInputStream(file);
      }



}

//Exceptions

//unchecked are not anticipated
    //should be able to run program without handling/mentioning these
    //ie exception handler or adding to the throws list

//checked ie reading class/file are anticipated exceptions
    //should be handled or mentioned in throws list


//STEPS FOR HANDLING EXCEPTIONS ----------------------throw/try/catch
//Throwing an exception -- creating an exception object and hand over to appropriate handler
    //if an appropriate handler is not present in code, the Java Runtime will hand over the exception to a default handler
    //default handler will then print the exception obj to screen and terminate the program

//We add handler by using try catch

//Throwable
//Exceptions
//RuntimeExceptions
//Error (occurs in the environment)

//UNCHECKED--------------------------------0
/*
//unchecked exception
        //nullpointerexception, purely logical factor
        String company = null;
        //nullpointerexception only occurs when we try to perform an operation on a variable that points to null
        System.out.println(company.length());
 */
//try block cannot exist alone, must come with catch blocks or finally
//catch block
/*
 catch(NullPointerException e){
            System.out.println("Program Cannot continue due to invalid input");
        }//without this handler, the last outprint will not execute bc it terminates at line 12
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Program failed to print the array value due to invalid numerical index");
        }catch (Exception e){ //parent type must come last//this line must come last or else everything will be matched to this one
            System.out.println(e);
        }
 */
//larger checked exceptions ex
/*
        String company = "stackroute";
        int[] scores = {89, 88};
        //Scanner scan = new Scanner(System.in);
        try(//can only place autocloseable resources here
            //try with resources block
            Scanner scan = new Scanner(System.in);
                )
        {
            System.out.println(5/0);
            System.out.println(company.length());
            System.out.println(scores[2]);
        } catch(NullPointerException e){
            System.out.println("Program Cannot continue due to invalid input");
        }//without this handler, the last outprint will not execute bc it terminates at line 12
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Program failed to print the array value due to invalid numerical index");
        }
        catch (Exception e){ //parent type must come last//this line must come last or else everything will be matched to this one
            System.out.println(e);
        }
//        finally{//java runtime will execute finally block before termination, if exception IS handled, it still executes
//            System.out.println("Finally is invoked");
//            //helpful for closing operations and resources
//            scan.close();
//        }
        //scan.close();
        System.out.println("Program Terminated Successfully");
 */

//memory leak
//garbage collection -- remove unused objects, objects still having reference, objects without reference
//unused objects still have reference, so garb coll
//will not know the obj is not in use
//so it will always be there in the memory
//--------------> memoryoutofboundexception


//CHECKED-----------------------------
//adding try and catch
/*
    public static void main(String[] args)
    {
        System.out.println("Exception Demo: ");
        System.out.println("------------------------");

        //file path / name does not exist
        File file = new File("");
        try {
            FileInputStream fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("Program Stopped: Invalid File Path");
        }

        System.out.println("Terminated Successfully");

    }
 */
//adding to throws list
/*
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Exception Demo: ");
        System.out.println("------------------------");

        //file path / name does not exist
        File file = new File("");

        FileInputStream fis = new FileInputStream(file);

        System.out.println("Terminated Successfully");

    }
 */

//propagating exception to prev method ex W STACK TRACE
/*
    public static void main(String[] args) {
        System.out.println("Exception Demo: ");
        System.out.println("------------------------");

        try {
            methodA();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Terminated Successfully");

    }

    public static void methodA() throws FileNotFoundException{
        methodB();
    }

    public static void methodB() throws FileNotFoundException{
        methodC();
    }

    public static void methodC() throws FileNotFoundException{
        File file = new File("");
        FileInputStream fis = new FileInputStream(file);

    }
 */

//vs handling at lowest method level
/*
    public static void main(String[] args) {
        System.out.println("Exception Demo: ");
        System.out.println("------------------------");

        methodA();

        System.out.println("Terminated Successfully");

    }

    public static void methodA(){
        methodB();
    }

    public static void methodB(){
        methodC();
    }

    public static void methodC(){
        File file = new File("");
        try {
            FileInputStream fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
 */
