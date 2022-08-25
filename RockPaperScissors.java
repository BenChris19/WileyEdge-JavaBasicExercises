import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author benatunderwoodquintana
 */
public class RockPaperScissors {
    
    public static void playGame(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Rock Paper Scissors");
        System.out.println("Please enter how many games you would like to play (Max:10 Min:1)");
        int games=sc.nextInt();
        try{
            if(games>11 || games<0){
                System.err.print("Please enter a suitable number!");
            }
            else{
                int ties=0;
                int compWin=0;
                int humanWin=0;
                
                for(int i=0;games>i;i++){
                    boolean appChoice = false;
                    while(!appChoice){
                        System.out.println("Please enter your choice \n 1=Rock \n 2=Paper \n 3=Scissor ");
                        int choice=sc.nextInt();
                        try{
                            if (choice>3 || choice<1){
                                System.out.print("Please enter an appropiate value!");
                            }
                            else{
                                appChoice=true;
                                int compChoice = new Random().nextInt(1,4);
                                if(choice==compChoice){
                                    System.out.println("It's a tie!");
                                    ties+=1;
                                }
                                else if((choice==1 && compChoice==2) || (choice==2 && compChoice==3)){
                                    System.out.println("Computer wins!");
                                    compWin+=1;
                                }
                                else{
                                    System.out.print("User wins!");
                                    humanWin+=1;
                                }
                            }
                        }
                        catch (NumberFormatException e){
                            System.err.print("Please enter a number!");
                        }
                }
            }
                System.out.println("Game has ended!");
                System.out.println("Results:\n Ties: "+ties+"\n User victories "+humanWin+"\n Computer victories "+compWin);
                if(compWin==humanWin){
                    System.out.print("Overall there are more ties!");
                }
                else{
                    String winner = compWin > humanWin ? "Computer is the overall winner!" : "Human is the overall winner!";
                    System.out.println(winner);
                }
                boolean againApp = false;
                try{
                    while (!againApp){
                        
                        System.out.println("Does the user want to play again? (Yes or No)");
                        String playAgain = sc.nextLine();
                        switch (playAgain) {
                            case "Yes" -> {
                                System.out.print("Restarting... \n");
                                playGame();
                                againApp = true;
                            }
                            case "No" -> {
                                System.out.print("Thanks for playing!");
                                againApp = true;
                            }
                            default -> System.out.print("Please enter Yes or No!");
                        }
                    }

                }
                catch (InputMismatchException e){
                    System.err.print("Please enter Yes or No!");
                }
            }
        }
        catch (NumberFormatException e){
            System.out.print("Please enter a number!");
        }        
    }
    public static void main(String[] args) {
        playGame();
    }
}
