import java.util.Scanner;
public class StringEncrypt {
    public static void main(String args[]){
        /* ---- VARIABLES ---- */
        String targetString;                        // String to be encrypted
        String lastLetter;                          // Last letter of the string
        String firstLetter;                         // First letter of the string
        String finalString;                         // Final iteration of the targetString
        String decryptedString;                     // Decrypted string
        Scanner scanner = new Scanner(System.in);   // Defines scanner for usage
        String userInput;                           // User input for decryption

        boolean encryptedMessage = false;           // When this is true the user can decrypt the same message again

        /* --- Strings --- */
        // These are preset strings that are printed when called in System.out.println
        String startMessage = "Please enter a word to be encrypted";
        String encryptingMessage = "Encrypting...";
        String encryptedString = "Your message has been encrypted!";
        String decryptionPrompt = "Would you like to decrypt your message? Y for yes N for no";
        String decryptingMessage = "Decrypting...";
        String errorMessage = "Oops! You didn't enter a valid letter!";
        String exitMessage = "See you next time!";

        /* --- Running the Program --- */
        System.out.println(startMessage);       // Print starting message
        targetString = scanner.next();          // Get users input
        System.out.println(encryptingMessage);  // Print message letting user know their input is being encrypted

        /* --- ENCRYPTION --- */
        System.out.println(encryptedString);    // Print preset message
        // Form the string with the following steps
        // 1) Get the last letter by using substring and strings length
        // 2) Form the final encrypted string by adding last letter in front and removing last letter from input and adding ay to the end
        lastLetter = targetString.substring(targetString.length()-1, targetString.length());
        finalString = lastLetter + targetString.substring(0,targetString.length()-1) + "ay";
        System.out.println(finalString);        // Print the final string

        /* --- DECRYPTION --- */
        boolean satisfied = false; // If prompt is satisfied make it true
        while (!satisfied){         // Loop for detecting if cases have been satisfied
            System.out.println("\n" + decryptionPrompt);    // Print a preset prompt
            userInput = scanner.next();                     // Scan for users input
            if(userInput.equals("Y")){                      // If they input Y
                // Print decrypting message
                System.out.println(decryptingMessage);      // Print preset message

                // Decrypt message
                firstLetter = finalString.substring(0,1);   // Get the first letter
                // Form the decrypted string by
                // Taking the finalString and printing the 2 to 3rd last character (removing the first letter and ay)
                // Then adding the first letter back at the end
                decryptedString = finalString.substring(1,finalString.length()-2) + firstLetter;
                System.out.println(decryptedString);        // Print output

                // User has satisfied input
                satisfied = true;
            }
            else if(userInput.equals("N")){
                // Print exit message and end program
                System.out.println(exitMessage);
                // User has satisfied input
                satisfied = true;
            }
            else{
                // Print error message
                System.out.println(errorMessage);
                // User has not satisfied input
            }
        }
    }
}
