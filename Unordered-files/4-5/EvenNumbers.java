package JavaTasks4_5;
public class EvenNumbers {

    public static void main(String[] args)
    {
        int x = 1000;

        System.out.println("Even Numbers:");
        for(int i = 1; i <= x; i++) {
            if(i%2==0){
                System.out.println(i);
            }
        }
    }
    
}
