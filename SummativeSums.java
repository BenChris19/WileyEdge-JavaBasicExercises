
import java.util.Scanner;

/**
 *
 * @author benatunderwoodquintana
 */
public class SummativeSums {

    
    private static int[] numbers(){
        int[] numArr = new int[1];
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How many numbers do you want to enter?");
        
        try{
            int amount = sc.nextInt();
            numArr = new int[amount];
            for (int i = 0; i < numArr.length; i++){
                System.out.println("Please enter number");
                try{
                    numArr[i] = sc.nextInt();
                }
                catch(Exception e){
                    System.out.print("Please only enter numbers!");
                } 
            }
        }
        catch(Exception e){
            System.out.print("Please only enter numbers!");
        }
        return numArr;
    }
    private static int sums(int[] arr){
        int res=0;
        for(int i: arr){
            res+=i;
        }
        return res;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = numbers();
        System.out.print(sums(arr));
    }
}
