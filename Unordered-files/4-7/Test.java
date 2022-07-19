package JavaTasks4_7;
public class Test {

    //is the main method dependent on the instance of Test Class? NO
    //can we say that main method is not dependent on the instance of Main Class(look at main.java)? Yes

    public void display() 
    {
        //no return type
    }

    public Test() 
    {
        //no return type required, default constructor
    }

    public Test(int a, int b)
    {
        //constructor, overloaded constructor
    }

    public static void main(String[] args) 
    {
        //------CONSTRUCTOR PRACTICE

        Car carObj; //simply declaring carObj as a member of Car class
        carObj  = new Car(); //holds the reference of the class called
        // same as above two lines---> Car carObj = new Car();

        // int add()
        // {
        //     return 4+5;
        // }

        // int num1;
        // num1 = add();

        carObj.carName = "Tesla";
        carObj.carModel = "zyzy";

        //this overwrites carObj 
        carObj.carName = "xxxxxxx";
        carObj.carModel = "zyzy";

        //display logic is written elsewhere
        carObj.display();
        Car.displayCar(); //vs carObj.displayCar; calling the Car class vs calling car instance object

        Car carObj2 = new Car();
        carObj2.carName = "XXX";
        carObj2.carModel = "XXX";

        Car carObj3 = new Car();
        carObj3.carName = "WWW";
        carObj3.carModel = "WWW";
    }
}

//constructors: methods used to intialize objects