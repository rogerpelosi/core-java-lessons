package JavaTasks4_5;
import java.util.Scanner;
public class ExceedSum {
    
    public static void main(String[] args) {
       
        Scanner request =  new Scanner(System.in);
        int sum = 0;


        while(sum <= 999){
            System.out.println("Enter Number");
            int num = request.nextInt();
            sum = num + sum;
            System.out.println("Current Sum: " + sum);
        }

        System.out.println("Error, sum exceeds or is equal to 999!");
    }
}
