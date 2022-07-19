package JavaTasks4_6;
import java.util.Scanner;
public class SumOfNeighbors {

    public static int[][] readInput(){

        //scan for user row/column input
        Scanner scan = new Scanner(System.in);
        System.out.println("How many rows are in your array?");
        int rows = scan.nextInt();
        System.out.println("How many columns are in your array?");
        int columns = scan.nextInt();

        //initialize new array using user row/column input
        int[][] baseArr = new int[rows][columns];

        //create actual multi dimensional array w above info & validate ind input
        for(int row = 0; row < baseArr.length; row++){
            for(int col = 0; col < baseArr[0].length; col++){
                //storing input in nextNum to validate it prior to adding to the base array, thus ensuring no 'bad data' is added
                int nextNum;
                System.out.println("Input Number:");
                nextNum = scan.nextInt();
                if(inputValidator(nextNum)){
                    baseArr[row][col] = nextNum;
                } else {
                    System.out.println("Please provide valid input:");
                    nextNum = scan.nextInt();
                    while(nextNum < 0){
                        System.out.println("Please provide valid input:");
                        nextNum = scan.nextInt();
                    }
                    baseArr[row][col] = nextNum;
                }
                // baseArr[row][col] = scan.nextInt();
            }

        }

        //return baseArray once input process completes
        return baseArr;

    }

    public static boolean inputValidator(int in){
        return in >= 0;
        // int x = 0;
        // for(int r = 0; r < arr.length; r++){
        //     for(int c = 0; c < arr.length; c++){
        //         // return (arr[r][c] > 0);
        //         if(arr[r][c] < 0){
        //             x+= 1;
        //         } 
        //     }
        // }
        // return x <= 0;
    }

    public static int[][] computeNeighborSum(int[][] arr){
        int sum = 0;

        //create new arr based on the rows and columns of base array being inputted
        int[][] newArr = new int[arr.length][arr[0].length];

        for(int r = 0; r < arr.length; r++) {
            for(int c = 0; c < arr[r].length; c++) {
                //iterate through to look at each ind element w/in original arr
                for(int x = r - 1; x < arr.length; x++){
                    for(int y = c -1; y < arr[r].length; y++){
                        if(!(x==r && y==c) && (x>=0) && (y>=0) && (x<=r+1) && (y<=c+1)){
                            sum += arr[x][y];
                        }
                    }
                }
                newArr[r][c] = sum;
                sum = 0;
                // System.out.println((newArr[r][c]));
            }
        }

        return newArr;
    }

    public static void displaySet(int[][] arr){
        for(int x = 0; x < arr.length; x++){
        for(int[] ints: arr){
            System.out.print(ints[x] + "\t");
        }
    }
        System.out.println();
    }
    //should be public static void readInput()
    public static void main(String[] arg)
    {

        int[][] firstArray = readInput();
        System.out.println("First Array As Follows:");
        displaySet(firstArray);

        // for(int i = 0; i < firstArray.length; i++){
        //     for(int j = 0; j < firstArray[i].length; j++) {
        //         System.out.println(firstArray[i][j]);
        //     }
        // }

        System.out.println("Second Array As Follows:");
        int[][] newNew = computeNeighborSum(firstArray);
        for(int i = 0; i < newNew.length; i++){
            for(int j = 0; j < newNew[i].length; j++){
                System.out.print(newNew[i][j] + ", ");
            }
        }

    }


    
}
