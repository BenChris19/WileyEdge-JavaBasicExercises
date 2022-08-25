
import java.util.Scanner;

/**
 *
 * @author benatunderwoodquintana
 */
public class HealthyHearts {
    
    private static int maxHeartRate(int num){
        return num<110 && num>0 ? 220-num:0;
    }
    private static double[] heartZone(int num){
        return new double[]{num*0.5,num*0.85};
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.print("What is your age? ");
        Scanner sc = new Scanner(System.in);
        
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
