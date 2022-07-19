package JavaTasks4_5;

// import java.time.Clock;
import java.time.LocalTime;

public class JavaDemo4 {

    public static void main(String[] args) 
    {

        // LocalTime now = LocalTime.now();
        // System.out.println(now);

        // Clock clock = Clock.systemDefaultZone();
        LocalTime now = LocalTime.now();
        // System.out.println("The time is " + now);
        String yu = now.toString().substring(0,2);
        System.out.println("The time is " + yu);

        int i=Integer.parseInt(yu); 
        // System.out.println(i);

        if(i < 11) {
            System.out.println("Good Morning!");
        } else  {
            System.out.println("Good Evening!");
        }
       

    }
    
}
