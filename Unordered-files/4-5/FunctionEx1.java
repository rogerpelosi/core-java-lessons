package JavaTasks4_5;

public class FunctionEx1 {

    int num;

    public static int add(int a, int b){
        return a+b;
    }
    public static int sub(){
        return 10-2;
    }

    public static int mult(int a, int b) {
        return a*b;
    }

    public static int mult1(String empName[]) {
        return Integer.parseInt(empName[0]);
    }

    public static void main(String[] arg) {

        int x = 19;
        int y = 23;
        System.out.println(mult(x, y) + add(x,y));
        // System.out.println(add(num1, num2));
    }

    
}
