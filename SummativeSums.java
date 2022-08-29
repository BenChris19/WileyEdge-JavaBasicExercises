package WileyEdgeExercises;


/**
 * A program which sums all the values of certain arrays and displays the results.
 *
 * @author benatunderwoodquintana
 */
public class SummativeSums {
    /**
     * Method which runs through each element in an array and displays overall result.
     * @param arr
     * @return an number of all of the sums
     */
    private static int sums(int[] arr){
        int res=0;
        for(int i: arr){
            res+=i;
        }
        return res;
    }

    /**
     * Main method with example of arrays with fixed values
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    	int[][] examples = new int[] []{{ 1, 90, -33, -55, 67, -16, 28, -55, 15 },
    			{ 999, -60, -77, 14, 160, 301 },
    			{ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 
    				140, 150, 160, 170, 180, 190, 200, -99 }};
    	for (int[] arr: examples) {
    		System.out.println(sums(arr));
    	}
    }
}
