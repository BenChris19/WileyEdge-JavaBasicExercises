package WileyEdgeExercises;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author benatunderwoodquintana
 */
public class DogGenetics {

    public static HashMap<String,Integer> breedsAndPercentage(){
        HashMap<String,Integer> breedPerc = new HashMap<>();
        List<String> dogBreeds = new ArrayList<>(Arrays.asList("St. Bernard","Chihuahua","Dramatic RedNosed Asian Pug","Common Cur",
                             "King Doberman","German Shepard","Bulldog","Poodle"));
        int percentage = 100;
        while(percentage>0){
            int randPerc = new Random().nextInt(1, percentage+1);
            int randomBreed= new Random().nextInt(0, dogBreeds.size());
            breedPerc.put(dogBreeds.remove(randomBreed),randPerc);
            percentage-=randPerc;   
        }
        
        return breedPerc;
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.print("What is your dog's name? ");
        try (Scanner sc = new Scanner(System.in)) {
			String name=sc.nextLine();
			
			System.out.println("Well then, I have this highly reliable report on "+name+"'s prestigious background right here.\n");
			System.out.println(name+"'s is:\n");
		}
        HashMap<String,Integer> breedPerc = breedsAndPercentage(); 
        for(String breed:breedPerc.keySet()){
            System.out.println(breedPerc.get(breed)+"% "+breed);
        }
        System.out.print("\n");
        System.out.println("Wow, that's QUITE the dog! ");
        
    }
}
