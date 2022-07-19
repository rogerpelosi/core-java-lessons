package JavaTasks4_6;

import java.util.Scanner;

public class MultiDimDemo {
    
    public static void main(String[] arg)
    {

        Scanner scan = new Scanner(System.in);
        //single dimensional array
        int[] num = new int[3];
        // num[0] = 12;
        // num[1] = 2;
        // num[2] = 1;

        for (int i = 0; i < num.length; i++){
            System.out.println("Enter number:");
            num[i]= scan.nextInt();
        }
        // System.out.println(num);

        for(int i = 0; i < num.length; i++)
        {
            System.out.println(num[i]);
        }

        //multi dimensional array starts
        int[][] num2 = new int[3][3];
        // num2[0][0] = 1000;
        // num2[1][0] = 2;
        // num2[2][0] = 3;
        // num2[0][1] = 4000;
        // num2[1][1] = 5;
        // num2[2][1] = 6;
        // num2[0][2] = 7000;
        // num2[1][2] = 8;
        // num2[2][2] = 9;

        // for(int i = 0; i < 2; i++)
        // {//i reps the row
        //     for(int j = 0; j < num2.length; j++){//j reps the column
        //         System.out.println(num2[i][j]);
        //         //goes thru all columns of first row, then goes to next row and all of its columns
        //     }
        //     // System.out.println(num2[i]);
        // }
  

    }
}
