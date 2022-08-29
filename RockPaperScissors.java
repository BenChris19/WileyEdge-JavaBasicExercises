package WileyEdgeExercises;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * A java program which is able to play Rock Paper Scissors with the user, and can ask the user
 * how many games they want to play.
 *
 * @author benatunderwoodquintana
 */
public class RockPaperScissors {
	
	private static Scanner sc;
        
        /**
        * We start by asking the user the number of games they want to play
        */
	private static void numberOfGames() {
		int numOfGames = 0;
		
        System.out.println("Welcome to Rock Paper Scissors");
        System.out.println("Please enter how many games you would like to play (Max:10 Min:1)");
        

        try (Scanner sc = new Scanner(System.in)) {
			numOfGames=sc.nextInt();
			
        	if(numOfGames>10 || numOfGames<1){ //Exit program if user has not inputed a number between 1 and 10
                System.err.println("Please enter a suitable number!");
                System.out.println("Game has ended");
            }
        	else {  
        		System.out.println("Number of games "+numOfGames+"\n");
        		playGames(numOfGames); //Start playing the game
        	}
        }
        catch(Exception e) {
        	System.err.print("Please enter a number!");
        }
	}
        /**
         * Play the number of games the user has entered
         * @param numOfGames 
         */
	private static void playGames(int numOfGames) {
		int[] results = new int[3]; //Index 0 for tie, 1 for computer victories and 2 for human victories
		sc = new Scanner(System.in);
			for(int i=0;numOfGames>i;i++){
				boolean appChoice = false;
				while(!appChoice){
					System.out.println("Please enter your choice \n1=Rock \n2=Paper \n3=Scissor ");
					try  {
						int choice=sc.nextInt(); //Get choice from the user
						
			            if (choice>3 || choice<1){
			                System.err.println("Please enter an appropiate value!");
			            }
			            else {
			            	appChoice = true;
			            	results[verifyResult(choice,compChoice())]+=1;
			            }
					}
			        catch(Exception e) {
			        	System.err.println("Please enter a number!");
			        	sc.next();
			        }
				}
			}
			winner(results);    //Display winner message and if they want to play again
	}
	/**
         * Generates a random number with the choice of the computer
         * @return a random number between 1 and 0
         */
	private static int compChoice() {
		return new Random().nextInt(1,4);
	}
	/**
         * Gets the result of the user's choice and the computer's choice
         * @param userChoice
         * @param compChoice
         * @return an integer where each number is the result of the rock paper scissors match
         */
	private static int verifyResult(int userChoice,int compChoice) {
		String compItem = switch(compChoice) {
			case 1 -> "Rock";
			case 2 -> "Paper";
			default -> "Scissors";
			};
		System.out.println("Computer has chosen "+ compItem);
        if(userChoice==compChoice){
            System.out.println("It's a tie!");
            return 0;
        }
        else if((userChoice==1 && compChoice==2) || (userChoice==2 && compChoice==3)){
            System.out.println("Computer wins!");
            return 1;
        }
        else{
            System.out.println("User wins!");
            return 2;
        }
        /**
         * Displays a message showing who is the winner, and the results of all of the games
         * and asks the user if they want to play again.
         */
	}
	private static void winner(int[] results) {
        System.out.println("Game has ended!");
        System.out.println("Results:\n Ties: "+results[0]+"\n User victories "+results[2]+"\n Computer victories "+results[1]);	
        
        if(results[1]==results[2]){
            System.out.println("Overall there are more ties!");
        }
        else{
            String winner = results[1] > results[2] ? "Computer is the overall winner!" : "Human is the overall winner!";
            System.out.println(winner);
            
        }
		System.out.println("Does the user want to play again? (Yes or No)");
		sc = new Scanner(System.in);
        playAgain();
	}
	private static void playAgain() {
			boolean againApp = false;
			while (!againApp){	
			try  {
				String playAgain = sc.nextLine();
			        switch (playAgain) {
			            case "Yes" -> {
			                System.out.print("Restarting... \n");
			                numberOfGames();//Play the game again
			                againApp = true;
			            }
			            case "No" -> {
			                System.out.print("Thanks for playing!");
			                againApp = true;
			            }
			            default -> System.err.println("Please enter Yes or No!");
			        }
			}
			catch (InputMismatchException e){
			    System.err.print("Please enter Yes or No!");
			    
			}            
			}

	}
    /**
     * Execute the main method of the program
     * @param args 
     */
    public static void main(String[] args) {
    	numberOfGames();
    }
}


//Previous code 


// public static void playGame(){
//  Scanner sc = new Scanner(System.in);
//  int[] res = playGames(numberOfGames(sc.nextInt()));
//  
//  
//  try{
//      if(games>11 || games<0){
//          System.err.print("Please enter a suitable number!");
//      }
//      else{
//          int ties=0;
//          int compWin=0;
//          int humanWin=0;
//          
//          for(int i=0;games>i;i++){
//              boolean appChoice = false;
//              while(!appChoice){
//                  System.out.println("Please enter your choice \n 1=Rock \n 2=Paper \n 3=Scissor ");
//                  int choice=sc.nextInt();
//                  try{
//                      if (choice>3 || choice<1){
//                          System.out.print("Please enter an appropiate value!");
//                      }
//                      else{
//                          appChoice=true;
//                          int compChoice = new Random().nextInt(1,4);
//                          if(choice==compChoice){
//                              System.out.println("It's a tie!");
//                              ties+=1;
//                          }
//                          else if((choice==1 && compChoice==2) || (choice==2 && compChoice==3)){
//                              System.out.println("Computer wins!");
//                              compWin+=1;
//                          }
//                          else{
//                              System.out.print("User wins!");
//                              humanWin+=1;
//                          }
//                      }
//                  }
//                  catch (NumberFormatException e){
//                      System.err.print("Please enter a number!");
//                  }
//          }
//      }
//          System.out.println("Game has ended!");
//          System.out.println("Results:\n Ties: "+ties+"\n User victories "+humanWin+"\n Computer victories "+compWin);
//          if(compWin==humanWin){
//              System.out.print("Overall there are more ties!");
//          }
//          else{
//              String winner = compWin > humanWin ? "Computer is the overall winner!" : "Human is the overall winner!";
//              System.out.println(winner);
//          }
//          boolean againApp = false;
//          try{
//              while (!againApp){
//                  
//                  System.out.println("Does the user want to play again? (Yes or No)");
//                  String playAgain = sc.nextLine();
//                  switch (playAgain) {
//                      case "Yes" -> {
//                          System.out.print("Restarting... \n");
//                          playGame();
//                          againApp = true;
//                      }
//                      case "No" -> {
//                          System.out.print("Thanks for playing!");
//                          againApp = true;
//                      }
//                      default -> System.out.print("Please enter Yes or No!");
//                  }
//              }
//
//          }
//          catch (InputMismatchException e){
//              System.err.print("Please enter Yes or No!");
//          }
//      }
//  }
//  catch (NumberFormatException e){
//      System.out.print("Please enter a number!");
//  }        
//}
