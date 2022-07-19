package JavaTasks4_5;

import java.util.Scanner;

public class ThreeNumbers {

    public static void main(String[] args)
    {
        Scanner sio = new Scanner(System.in);

        int num1 = sio.nextInt();
        int num2 = sio.nextInt();
        int num3 = sio.nextInt();

        if(num1 > num2 && num1 > num3) {
            System.out.println(num1);
        } else if(num2 > num1 && num2 > num3) {
            System.out.println(num2);
        } else {
            System.out.println(num3);
        }
    }
    
}
