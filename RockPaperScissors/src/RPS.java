// Import the scanner for testing the player input
import java.util.Scanner;

// Quick note sometimes for headers I prefer using the /**/ comment because it looks nicer!

public class RPS {
    // This function help with the replay function of the game
    static  void replayGame(){
        /* --- MESSAGES --- */
        String prompt = "\nPRESS 'Y' to play again!";         // Printed when the function is called

        // Say prompt
        System.out.println(prompt);                         // This prints the prompt when functsion is called

        /* --- DEFINE SCANNER --- */
        Scanner scan = new Scanner(System.in);              // Defines scanner and allows for use
        String playerInput = scan.next();                   // Scans next line and stores it in the playerInput variable

        /* --- DETECT INPUT --- */
        if(playerInput.equals("Y")){                        // If the player enters Y
            playGame();                                     // Re-Run the game
        }
        else{                                               // If the player doesn't enter Y
            System.out.println("Oh Ok.");                   // Print Oh ok.
        }
    }

    // Added this function that runs the main game
    static void playGame(){
        /* --- MESSAGES --- */
        String startMessage = "Welcome to Rock Paper Scissors! Enter 'R' for ROCK, 'P' for PAPER and 'S' for SCISSORS!"; // Printed when game is run
        String tieMessage = "It's a TIE!"; // Printed when it is a tie
        String winMessage = "You WIN!"; // Printed when you win
        String loseMessage = "You LOSE!"; // Printed when you lose
        String replayMessage = "Would you like to play again? Enter Y for YES and N for NO"; // Printed after a round is over
        String errorMessage = "Oops! Looks like you entered something besides R, P, and S. Please Try again!"; // Printed when something goes wrong
        String computerPickedMessage = "The Computer Picked: ";
        String playerPicked = "You Picked: ";

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
            }
            else if(computerChoice == 1){           // If computer chooses paper
                System.out.println(loseMessage);    // Print lose message
            }
            else {                                  // If player chooses rock and none of above cases are true
                System.out.println(winMessage);     // That means computer chose scissors and print win message!
            }
        }
        else if(playerInput.equals("P")){           // If the player chooses paper
            if(computerChoice == 1){                // If computer chooses paper too
                System.out.println(tieMessage);     // Print tie message
            }
            else if(computerChoice == 2){           // If computer chooses scissors
                System.out.println(loseMessage);    // Print lose message
            }
            else {                                  // If player chooses paper and none of above cases are true
                System.out.println(winMessage);     // That means computer chose rock and print win message!
            }
        }
        else if(playerInput.equals("S")){           // If the player chooses scissors
            if(computerChoice == 2){                // If computer chooses scissors too
                System.out.println(tieMessage);     // Print tie message
            }
            else if(computerChoice == 0){           // If computer chooses rock
                System.out.println(loseMessage);    // Print lose message
            }
            else {                                  // If player chooses scissors and none of above cases are true
                System.out.println(winMessage);     // That means computer chose paper and print win message!
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

        // Run the replayGame function
        replayGame();
    }
    // This is used to run the game initially
    public static void main(String args[]){
        // Run playGame function
        playGame();
    }
}
