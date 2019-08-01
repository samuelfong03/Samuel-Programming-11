// We need the scanner for user input
import java.util.Scanner;
public class ArrayManager {
    public static void main(String args[]){
        /* ---- VARIABLES ---- */
        Scanner scanner = new Scanner(System.in); // Define scanner for use
        int[] currentArray = new int[0]; // This is the current array that stores ints this is changed with the functions
        boolean quitProgram = false; // Bool controlling whether or not to keep running the program
        int indexInt; // Used when inserting ints into the array it stores the index you want to insert the value in

        /* ---- MESSAGES ---- */
        // Sets of preset messages to be printed later
        // Messages are named as when they are called
        String header = "\n------------------------------------------------";
        String welcomeString = "Welcome to the Array Manager.\nTo add values to your array, type 'add'\nTo remove values from your array type 'delete'\nTo insert values to your array type 'insert'\nTo view all indexes type 'list'\nAfter finishing an operation if u wish to leave type 'quit'";
        String addString = "You have selected: ADD\nPlease enter a number that you would like to add.";
        String deleteString = "You have selected: DELETE\nPlease enter the index that you would like to remove.";
        String insertString1 = "You have selected: INSERT\nPlease enter the index you would like to insert a value in";
        String insertString2 = "Please enter the value you would like to placed in index ";
        String quitMessage = "Thanks for using Array Manager!";
        String errorString = "Oops! You didn't enter a valid input! Please try again!";
        String error2String = "Oops! There isn't anything in the array right now! Please try again!";
        String error3String = "Oops! The value you entered was too large so I scaled it down to ";

        /* ---- RUN PROGRAM ---- */
        while(!quitProgram){ // While the user wants to use the program
            System.out.println(welcomeString + header); // Start by printing welcome string

            switch (userInput().toLowerCase()){ // Detect user input and detect what was chosen .toLowerCase makes it so that the entered string is converted to lower case meaning what case the user enters does not matter
                /* --- ADD --- */
                case "add": // Case for when player enters "add"
                    System.out.println(addString); // Print preset message
                    currentArray = addValues(currentArray, inputInt());

                    printAll(currentArray); // Call a function that prints everything in the selected array in this case current array
                    System.out.print(header + "\n"); // Print a header to separate things and make things look nicer
                    break;
                /* ---  DELETE --- */
                case "delete":  // This case is triggered when userInput is delete
                    if(currentArray.length > 0){ // If there are contents in the array
                        System.out.println(deleteString); // Print preset message
                        // Call a function that prints everything in the selected array in this case current array
                        // This is called so you know what is in your array to erase
                        printAll(currentArray);
                        currentArray = deleteValues(currentArray, inputInt()); // Set the current array to output of a function, explained later
                        System.out.println(header); // Print header to make things nicer
                    }
                    else{ // Else there are no contents to delete print error message
                        System.out.println(error2String + header); // Print preset message and header
                    }
                    break;
                /* --- INSERT --- */
                case "insert":  // This case is triggered when userInput is insert
                    System.out.println(insertString1); // Print first half of preset message (The first part gets desired insert index)
                    // Call a function that prints everything in the selected array in this case current array
                    // This is so user knows what is in the current array and what index to pick to insert values to
                    printAll(currentArray);
                    indexInt = inputInt(); // Set index int to the input int with a function explained later
                    // Handle error if user enters an index that is too big
                    if(indexInt > currentArray.length){ // If the current index is too big (larger than final inserted array)
                        indexInt = currentArray.length; // Set the insert index to the largest number
                        System.out.println(error3String + indexInt); // Print present message telling user their number was scaled down
                    }
                    System.out.println(insertString2 + indexInt); // Print second half of preset message (Second part gets desired value)
                    currentArray = insertValues(currentArray, indexInt, inputInt()); // Use function to insert a value using indexint and the next input int
                    // Call a function that prints everything in the selected array in this case current array
                    // This is so you know what the new array looks like
                    printAll(currentArray);
                    System.out.println(header); // Print header to make things look nicer
                    break;
                /* ---  LIST (QUICK CUSTOM ADDITION) ---*/
                case "list":    // This case is triggered when userInput is list
                    if(currentArray.length > 0){ // If the array is not empty
                        printAll(currentArray); // Call a function that prints everything in the selected array in this case current array
                        System.out.println(header); // Print header to make things look nicer
                    }
                    else{ // Otherwise the array is empty and there is nothing to print
                        System.out.println(error2String + header); // Print preset error message and header
                    }
                    break;
                /* --- QUIT (QUICK CUSTOM ADDITION) --- */
                case "quit": // This case is triggered when userInput is quit
                    quitProgram = true; // Set variable controlling while loop to true to end loop
                    System.out.println(quitMessage); // Print preset quit message
                    break;
                /* --- ERROR CASE ---*/
                default: // Like an else case this is triggered when none of the above cases are fulfilled
                    System.out.println(errorString + header); // Print a preset error message and header
                    break;
            }
        }
    }
    /* ---- NEW METHODS ---- */
    /* ---  ADD VALUES --- */
    // This method takes a array and int
    public static int[] addValues(int[] inputArray, int newValue){
        /* --- METHOD VARIABLES --- */
        int[] newArray = new int[inputArray.length + 1]; // Sets size of new array to be the selected array plus one to fit extra index

        /* --- COPY ARRAY VALUES --- */
        for (int i = 0; i < inputArray.length; i++){ // For each (i)index
            newArray[i] = inputArray[i]; // Set newArrays index values equal to the inputArray so that we can get a completed final array to be returned
        }
        /* --- ADD NEW VALUE TO THE END --- */
        newArray[newArray.length - 1] = newValue; // Add final value to end of array

        return newArray; // Return the new arrays values
    }

    /* --- DELETE VALUES --- */
    // This method takes an array and an int
    public static int[] deleteValues(int[] inputArray, int deleteIndex){
        /* --- METHOD VARIABLES ---*/
        int[] newArray = new int[inputArray.length - 1]; // Sets size of new array to be the selected array minus one to account for removed index

        /* --- COPY ARRAY VALUES --- */
        for (int i = 0; i < inputArray.length - 1; i++){ // For each (i)index
            if(i < deleteIndex){ // If the index is lower than the index to be deleted
                newArray[i] = inputArray[i]; // Set the new arrays current index to the input arrays same index
            }
            else{ // Otherwise
                newArray[i] = inputArray[i + 1]; // Set the new arrays current index to the selected arrays index plus one to skip the deleted one
            }
        }
        return newArray; // Return final values of the new array
    }

    /* --- INSERT VALUES --- */
    // This method takes an array, index number, and a value
    public static int[] insertValues(int[] inputArray, int index, int value){
        /* ---  METHOD VARIABLES --- */
        int[] newArray = new int[inputArray.length + 1]; // Sets size of new array to selected array plus 1 to account for inserted index

        /* --- COPY ARRAY VALUES --- */
        for(int i = 0; i < inputArray.length + 1; i++){ // For every (i)index
            if(i < index){ // If the index is less then index that a value will be inserted in
                newArray[i] = inputArray[i]; // Set the new arrays current index to the input arrays same index
            }
            else{ // Otherwise
                newArray[i] = inputArray[i - 1]; // Set the current index to the input arrays index -1
                // NOTE: I know this seems dumb because it will write something into the slot that we want something inserted in however we over write that
            }
            newArray[index] = value; // Overwrite the chosen index's slot with the chosen value
        }
        return newArray; // Return final array
    }

    /* --- MY METHODS --- */
    public static String userInput(){ // Function to get users input (String)
        Scanner scanner = new Scanner(System.in); // Define scanner
        String input = scanner.next(); // Scan the next line

        return input; // Return string
    }

    public static int inputInt(){ // Function to get users input (Int)
        Scanner scanner = new Scanner(System.in); // Define scanner
        boolean satisfied = false; // Keeps while loop going until input has been satisfied
        int input = 0; // int for input
        String errorString = "Oops! Looks like you didn't enter an int! Please try again.";

        while(!satisfied){
            if(scanner.hasNextInt()){
                input = scanner.nextInt();
                satisfied = true;
            }
            else {
                System.out.println(errorString);
                break;
            }
        }
        return input; // Return int
    }

    public static void printAll(int[] selectedArray){ // Function to print all indexes of certain array. This function takes an array
        for(int i = 0; i < selectedArray.length; i++){ // For every (i)index of selected array
            System.out.println("Index: " + i + " Value: " + selectedArray[i]); // Print out the index number followed by the value of the index
        }
    }
}
