package JavaTasks4_4;

import java.util.Scanner;

public class JavaTask2 {

    final static double ASSIGNMENT_VALUE = 0.1;
    final static double PROJECT_VALUE = 0.35;
    final static double QUIZ_VALUE = 0.1;
    final static double MIDTERM_VALUE = 0.15;
    final static double FINAL_VALUE = 0.30;

    public static void main (String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("Enter Assignment Score: ");
        double studentAssignmentScore = console.nextDouble();
        
        System.out.println("Enter Project Score: ");
        double studentProjectScore = console.nextDouble();

        System.out.println("Enter Quiz Score: ");
        double studentQuizScore = console.nextDouble();

        System.out.println("Enter Midterm Score: ");
        double studentMidtermScore = console.nextDouble();

        System.out.println("Enter Final Score: ");
        double studentFinalScore = console.nextDouble();

        double weightedAssignmentScore = studentAssignmentScore * ASSIGNMENT_VALUE;
        double weightedProjectScore = studentProjectScore * PROJECT_VALUE;
        double weightedQuizScore = studentQuizScore * QUIZ_VALUE;
        double weightedMidtermScore = studentMidtermScore * MIDTERM_VALUE;
        double weightedFinalScore = studentFinalScore * FINAL_VALUE;
        
    }
    
}
