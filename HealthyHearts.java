package WileyEdgeExercises;


import java.util.Scanner;

/**
 * A program which displays the user their max heart rate and heart zone according to their age
 *
 * @author benatunderwoodquintana
 */
public class HealthyHearts {
    /**
     * //If the number is a suitable value calculate max heart rate
     * @param num
     * @return the max heart rate of the individual if true, else return 0
     */
    private static int maxHeartRate(int num){
        return num<110 && num>0 ? 220-num:0; 
    }
    /**
     * Return the heart zone of the individual
     * @param num
     * @return a double list showing the minimum and maximum heart zone
     */
    private static double[] heartZone(int num){
        return new double[]{num*0.5,num*0.85};
        
    }

    /**
     * Executes the program
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.print("What is your age? ");
        try (Scanner sc = new Scanner(System.in)) {
			try{
			    int age = sc.nextInt();
			    if(maxHeartRate(age) >0){
			        System.out.println("Your maximum heart rate should be "+maxHeartRate(age)+" beats per minute");
			        System.out.println("Your target HR Zone is "+(int)heartZone(maxHeartRate(age))[0]+
			            " - "+(int)heartZone(maxHeartRate(age))[1]+" beats per minute");
			    }
			    else{
			        System.out.print("Please enter a valid age!");
			    }
			}
			catch(Exception e){
			    System.err.print("Please enter your age!");
			}
		}
    }
}
