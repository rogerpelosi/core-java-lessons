package JavaTasks4_5;
import java.util.Scanner;

public class FishTank {

    public static void main(String[] args) 
    {
        Scanner request = new Scanner(System.in);
        int phVal = request.nextInt();

        // int phVal = 1;

        System.out.println((phVal >= 7 && phVal <= 8 ? "pH Value is fine" : (phVal < 7 ? "pH is low" : "pH is high")));

        // if(phVal >=7 && phVal <= 8) {
        //     System.out.println("pH Value is Fine");
        // } else if(phVal > 8) {
        //     System.out.println("pH value is high, partial water change required");
        // } else {
        //     System.out.println("pH value is low, partial water change required");
        // }

    }
    
}
