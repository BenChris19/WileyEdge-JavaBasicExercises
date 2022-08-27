package WileyEdgeExercises;


/**
 *
 * @author benatunderwoodquintana
 */
public class SummativeSums {

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
    	int[][] examples = new int[] []{{ 1, 90, -33, -55, 67, -16, 28, -55, 15 },
    			{ 999, -60, -77, 14, 160, 301 },
    			{ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 
    				140, 150, 160, 170, 180, 190, 200, -99 }};
    	for (int[] arr: examples) {
    		System.out.println(sums(arr));
    	}
    }
}
