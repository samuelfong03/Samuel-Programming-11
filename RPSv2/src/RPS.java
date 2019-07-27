// Import the scanner for testing the player input
import java.util.Scanner;

// Quick note sometimes for headers I prefer using the /**/ comment because it looks nicer!

public class RPS {
    // Added this function that runs the main game
    static void playGame(){
        /* --- MESSAGES --- */
        String startMessage = "Welcome to Rock Paper Scissors! \nEnter 'R' for ROCK, 'P' for PAPER and 'S' for SCISSORS!"; // Printed when game is run
        String tieMessage = "It's a TIE!"; // Printed when it is a tie
        String winMessage = "You WIN!"; // Printed when you win
        String loseMessage = "You LOSE!"; // Printed when you lose
        String replayMessage = "Would you like to play again? Enter Y for YES and N for NO"; // Printed after a round is over
        String errorMessage = "Oops! Looks like you entered something besides R, P, and S. Please Try again!"; // Printed when something goes wrong
        String computerPickedMessage = "The Computer Picked: ";
        String playerPicked = "You Picked: ";
        String banner = "\n@---------------------------------@"; // Banner that is printed to seperate old and new games
        String quitPrompt = "\nPRESS 'Y' to play again or PRESS 'N' to stop playing!"; // Called at end of game asking if player wants to play again
        String byeMessage = "See you next time!";
        String error2Message = "Oops! You didn't enter 'Y' or 'N'. Please try again!"; // Printed when replay game's input is not correct

        /* --- VARIABLES --- */
        Boolean keepPlaying = true; // Controls while loop. When false game will stop playing
        int playerWins = 0; // Amount of wins player has
        int computerWins = 0; // Amount of wins computer has
        int ties = 0; // This is just for fun, amount of ties

        while (keepPlaying){
            // Print banner
            System.out.println(banner);
            // Print Current Standings
            System.out.println("Computer: " + computerWins + "\tPlayer: " + playerWins + "\tTies: " + ties);

            // Print welcome message
            System.out.println(startMessage);

            /* --- DEFINE SCANNER --- */
            Scanner scan = new Scanner(System.in); // Allows for us to collect the players input

            /* --- GENERATE COMPUTER'S CHOICE ---*/
            double rand = Math.random()*3; // Get a random number from 0-2
            // Store a random double in a double
            // (I am using double because your casting to int doesn't work for some reason always outputs 0)
            // When using (int)Math.Random, it rounds number to 0 before multiplying so you always get 0
            // This is why I am storing the random double THEN casting it as an int into the computersChoice variable
            int computerChoice = (int)rand; // Cast rand(double) to int and assign that to the final variable

            /* --- PLAYER INPUT SECTION --- */
            String playerInput = scan.next(); // Send the scanned text to playerInput variable

            /* --- WIN CASE DETECTION --- */
            // Numbers that correspond to what the computer chose
            // 0 = Rock
            // 1 = Paper
            // 2 = Scissors
            if(playerInput.equals("R")){                // If the player chooses rock (.equals checks content of the objects whereas == compares to see if they are the exact same.
                if(computerChoice == 0){                // If computer chooses rock too
                    System.out.println(tieMessage);     // Print tie message
                    ties++;
                }
                else if(computerChoice == 1){           // If computer chooses paper
                    System.out.println(loseMessage);    // Print lose message
                    computerWins++;
                }
                else {                                  // If player chooses rock and none of above cases are true
                    System.out.println(winMessage);     // That means computer chose scissors and print win message!
                    playerWins++;
                }
            }
            else if(playerInput.equals("P")){           // If the player chooses paper
                if(computerChoice == 1){                // If computer chooses paper too
                    System.out.println(tieMessage);     // Print tie message
                    ties++;
                }
                else if(computerChoice == 2){           // If computer chooses scissors
                    System.out.println(loseMessage);    // Print lose message
                    computerWins++;
                }
                else {                                  // If player chooses paper and none of above cases are true
                    System.out.println(winMessage);     // That means computer chose rock and print win message!
                    playerWins++;
                }
            }
            else if(playerInput.equals("S")){           // If the player chooses scissors
                if(computerChoice == 2){                // If computer chooses scissors too
                    System.out.println(tieMessage);     // Print tie message
                    ties++;
                }
                else if(computerChoice == 0){           // If computer chooses rock
                    System.out.println(loseMessage);    // Print lose message
                    computerWins++;
                }
                else {                                  // If player chooses scissors and none of above cases are true
                    System.out.println(winMessage);     // That means computer chose paper and print win message!
                    playerWins++;
                }
            }
            else {                                      // If the player doesn't input a valid letter print error message
                System.out.println(errorMessage);       // Print Error Message
            }

            /* --- FINISHING PROMPT --- */
            // Print the Computers Choice
            if(computerChoice == 0){                                        // Based on what the computer picked, print what the computer picked
                System.out.print(computerPickedMessage + "ROCK\t");
            }
            else if(computerChoice == 1){                                   // Based on what the computer picked, print what the computer picked
                System.out.print(computerPickedMessage + "PAPER\t");
            }
            else{                                                           // Based on what the computer picked, print what the computer picked
                System.out.print(computerPickedMessage + "SCISSORS\t");
            }

            if(playerInput.equals("R")){                                    // Based on what the player picked, print what the computer picked
                System.out.print(playerPicked + "ROCK");
            }
            else if(playerInput.equals("P")){                               // Based on what the player picked, print what the computer picked
                System.out.print(playerPicked + "PAPER");
            }
            else if(playerInput.equals("S")){                               // Based on what the player picked, print what the computer picked
                System.out.print(playerPicked + "SCISSORS");
            }

            /* --- KEEP PLAYING OR NO --- */
            Boolean satisfied = false;              // When true, replay/exit prompts will end
            while (!satisfied){
                System.out.println(quitPrompt);     // Prompts the player if he/she wants to continue playing
                playerInput = scan.next();          // Looks for input from player

                // Check what player input
                if(playerInput.equals("Y")){        // If player enters Y

                    // Required input has been satisfied so set satisfied to true
                    satisfied = true;
                }
                else if(playerInput.equals("N")){
                    System.out.println(byeMessage); // Print bye message
                    keepPlaying = false;            // End while loop that runs game

                    // Required input has been satisfied so set satisfied to true
                    satisfied = true;               // Set satisfied to true

                    // For fun, print out final standings
                    // Print Current Standings
                    System.out.println("Final Standings:\nComputer: " + computerWins + "\tPlayer: " + playerWins + "\tTies: " + ties);
                }
                else {
                    System.out.println(error2Message);// Print an error message
                    // Answer was not satisfied so keep prompting player to enter something
                }
            }
        }
    }

    // This is used to run the game initially
    public static void main(String args[]){
        playGame();
    }
}