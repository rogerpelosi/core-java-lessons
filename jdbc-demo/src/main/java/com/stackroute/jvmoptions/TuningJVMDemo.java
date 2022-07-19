package com.stackroute.jvmoptions;

/*

+jvm provides environment for java application
+JVM will run as a single process with parallel threads

TWO THREAD TYPES: MAIN THREAD AND DAEMON THREAD
    +main thread refers to main program we are using, user thread
    +daemon threads are supporting threads

+Garbage collector --> type of daemon thread-------------------------------
    +(Automatic Memory Management Process, runs parallel as a separate daemon thread)
    +manages/monitors heap memory
    1. (MARKING())-->identify objects in/not in use (live/dead&garbage objects)
       >object loses reference when program moves out of scope or a method pops out of stack
    2. (DELETE())-->removes/delete objects not in use (dead/garbage objects, with no reference or pointers in stack)
    3. (COMPACT())-->compact the memory ()

+as a developer, we can fine tune how java deals with the memory
+upon launch jvm uses default memory storage processes
STACK MEMORY------------------------------------------------------
    +at start methods are pushed to stack, it loads methods + stores primitive values one-by-one, then terminates when none are left
HEAP MEMORY----------------------------------------------------------
    +objects, classes, metadata are all stored here, along with static members(variables, methods)

+when threshold is reached, GC will monitor heap memory and go through objects to see which are necessary, remove unneeded ones for new ones to be allocated to heap memory

+right click class --> modify run configuration
    --> in modify run config we can pass program arguments and to jvm itself
    --> java -Xmx6m -Xms1m sample (altering max memory to 6)

$$$$$MORE TIME SPENT IN GARBAGE COLLECTION, MORE TIME PROGRAM WILL TAKE TO RUN
    -not all objects are long-living
    -Short living objects are smaller in numbers than long living objects
    based on above assumption, heap memories are separated into parts

Heap memory division, different parts called generations
1.Young Generation --> Minor Garbage Collection/gc
    -Eden Space (new objects get created here)
    -Survivors(S0 and S1) (when eden runs out, objs are moved here to free up eden again)(if these reach a particular threshold, then moved to old/tenured)
2.Old/Tenured Generation (once old gen runs out, deletes unused objs here) --> Major gc
3.Permanent Generation/Metaspace (classes, static members, string pool)

+garbage collection occurs most frequently in the young generation

---------if program has more static collections, gc is run in permanent space as well/metaspace
---------different algorithms perform based on heap division

GC types / algorithms:
-serial gc (not multithreading)
-parallel gc (enables multithreading for young generation)
-parallel old gc (enables multithreading for old gen)
-CMS (concurrent mark swap)

 */

public class TuningJVMDemo {

    public static void main(String[] args) {

        System.out.println("Tuning JVM Demo");
        System.out.println("^^^^^^^^^^^^^^^");

        String name = "Roger";//object stored in heap, reference stored in stack until all instructions are completed in this specific method
        //once everything is executed, THEN main pops out of stack memory, then refernce point in stack disappears, then obj becomes dead in heap

        Runtime runtime = Runtime.getRuntime();

        System.out.println("Max Memory");
        System.out.println(runtime.maxMemory()/Math.pow(2,20) + " MB");

        System.out.println("Total Memory");
        System.out.println(runtime.totalMemory()/Math.pow(2,20) + " MB"); //dividing 2 power 20

        System.out.println("Free Memory");
        System.out.println(runtime.freeMemory()/Math.pow(2,20) + " MB");

        print(90);

    }

    public static void print(int count){

        String name = "roger";//this will lose reference when print is popped out of stack
        System.out.println(count--);

        if(count > 0){
            String block = "if block";//once condition is false, object loses reference
            print(count);
        }

    }

}

//FIRST RUN-THROUGH EXAMPLE
/*
public class TuningJVMDemo {

    public static void main(String[] args) {

        System.out.println("Tuning JVM Demo");
        System.out.println("^^^^^^^^^^^^^^^");

        //get access to runtime env to learn properties of jvm
        Runtime runtime = Runtime.getRuntime();

        System.out.println("Max Memory");
        //for heap, what is max? returned in bytes, uses 1/4 of physical memory
        System.out.println(runtime.maxMemory()/Math.pow(2,20) + " MB");
        //4062.0 MB, which is a lot we do not need for this program

        System.out.println("Total Memory");
        System.out.println(runtime.totalMemory()/Math.pow(2,20) + " MB"); //dividing 2 power 20

        //after running this program, how much memory is left?
        System.out.println("Free Memory");
        System.out.println(runtime.freeMemory()/Math.pow(2,20) + " MB");

    }

}
 */

//FINE TUNING JVM (-Xms2m -Xmx2m -Xss180k)
/*
ORDER OF METHODS PUSHED TO STACK (JUST PRINTING, NOT STORING DATA)
****main doesn't leave stack until after print completes
print(7) ... until print(1)
print(8)
print(9)
print(10)
main()

-----------------------

public class TuningJVMDemo {

    public static void main(String[] args) {

        System.out.println("Tuning JVM Demo");
        System.out.println("^^^^^^^^^^^^^^^");

        Runtime runtime = Runtime.getRuntime();

        System.out.println("Max Memory");
        System.out.println(runtime.maxMemory()/Math.pow(2,20) + " MB");

        System.out.println("Total Memory");
        System.out.println(runtime.totalMemory()/Math.pow(2,20) + " MB"); //dividing 2 power 20

        System.out.println("Free Memory");
        System.out.println(runtime.freeMemory()/Math.pow(2,20) + " MB");

        print(10);

    }

    public static void print(int count){

        System.out.println(count--);

        if(count > 0){
            print(count);
        }

    }

}
 */

//NOTES ON SCOPE OF STACK MEMORY AND PUSHING OUT OF STACK AND REFERENCE LOSS
