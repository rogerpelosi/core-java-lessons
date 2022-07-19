package JavaTasks4_5;
public class PostClassWork {

    public static int empCount(String[][] set){
        return set.length;
    }

    public static double avgAge(String[][] set){
        double avg = 0;
        for(int i =0; i < set.length; i++){
            avg = avg + Integer.parseInt(set[i][2]);
        }
        return avg/empCount(set);
    }

    public static void main(String[] args)
    {
        String[][] empDetails = {
            {"e001", "David", "26"},
            {"e002", "Tim", "29"},
            {"e003", "Luke", "45"},
            {"e004", "Katy", "66"}
        };

        System.out.println(empCount(empDetails) + " employees work here");
        System.out.println("Their average age is " + avgAge(empDetails));

    
    }
    
}
