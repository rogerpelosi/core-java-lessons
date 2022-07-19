package JavaTasks4_7;
public class Car {

    //default access specifier
    String carName;
    String carModel;

    public  void display()
    {
        System.out.println(carName);
        System.out.println(carModel);
        // Car.displayCar();
    }

    public static void displayCar()
    {
        System.out.println("Message From Static Member of the Car Class!!");
    }
    
}

//in a software project, many things work to achieve single objective 

//team1 creates class1
//team2 creates class2
//team3 creates class3

//team4 uses class1 which is created by team1, but team1 does not want to provide the access to ALL attributes and behaviors of class1, thus some of these are encapsulated or hidden from team4

//sometimes we use 3rd party tools w/in our program and the services provided by 3rd party depends upon the type of subscriptions we have taken ie: -->

//airline booking app, will also get you hotel facility booking which belongs to 3rd party

//as programmer we should not expose the variables to different classes
