import java.util.Date; // Import to use Date
import java.util.Scanner; // Import to use Scanner

public class Main {
    public static void main(String[] args) {
        /* ---- VARIABLES ----*/
        Scanner scanner = new Scanner(System.in); // Define scanner for use
        Customer customer = new Customer("bert", 001, 0, 0); // Create a new customer
        Date date; // Define date to be used later

        /* ---- MESSAGES ---- */
        // Set of preset messages
        String header = "------------------------------------------------------------------------------------";
        String startString = "Welcome to the bank\nTo deposit money into your checking account enter 'depositchecking'\nTo deposit money into your savings account enter 'depositsaving'\nTo withdraw from your checking account enter 'withdrawchecking'\nTo withdraw from your savings account enter 'withdrawsaving'\nTo check your account balance enter 'balance'\nTo quit enter 'quit'";
        String helpString = "When preforming operations you may enter the amount after the command.\nFor example:\ndepositchecking 400\nor\nwithdrawchecking 400";

        boolean runProgram = true; // Bool that controls program loop
        while(runProgram){ // While runProgram is true run this loop
            System.out.println(header + "\n" + startString + "\n" + header + "\n" + helpString + "\n" + header); // Print a header with message
            switch (scanner.next().toLowerCase()){ // Switch case dependant on user input
                case "depositchecking": // Case for depositchecking
                    date = new Date(); // Create a new date with current time
                    customer.deposit(scanner.nextInt(), date, "Checking"); // Call deposit on customer using input values
                    break;
                case "depositsaving": // Case for depositsaving
                    date = new Date(); // Create a new date with current time
                    customer.deposit(scanner.nextInt(), date, "Saving"); // Call deposit on customer using input values
                    break;
                case "withdrawchecking": // Case for withdrawchecking
                    date = new Date(); // Create a new date with current time
                    customer.withdraw(scanner.nextInt(), date, "Checking"); // Call withdraw on customer using input value
                    break;
                case "withdrawsaving": // Case for withdrawsaving
                    date = new Date(); // Create a new date with current time
                    customer.withdraw(scanner.nextInt(), date, "Saving"); // Call withdraw on customer using input values
                    break;
                case "balance": // Case for balance
                    System.out.println("Checking: " + customer.getCheckBalance()); // Print out customers current checking balance
                    System.out.println("Saving: " + customer.getSavingBalance()); // Print out customers current savings balance
                    break;
                case "listdeposits": // Case for listdeposits
                    System.out.println("Deposits:"); // Print a header
                    for (int i = 0; i < customer.getDeposits().size(); i++){ // For every item in Deposits (Accessed with getter)
                        System.out.println(customer.getDeposits().get(i)); // Print out each deposit (Accessed with getter and .get(i))
                    }
                    break;
                case "listwithdraws": // Case for listwithdraws
                    System.out.println("Withdraws:"); // Print a header
                    for (int i = 0; i < customer.getWithdraws().size(); i++){ // For every item in Withdraws (Accessed with getter)
                        System.out.println(customer.getWithdraws().get(i)); // Print out each withdraw (Accessed with getter and .get(i)
                    }
                    break;
                case "quit": // Case for quit
                    runProgram = false; // Set runProgram to false
                    break;
                default: // "Else" case in a switch (Run when none of the above cases are fulfilled)
                    System.out.println("Oops you entered an invalid input! Please try again"); // Print an error message
                    break;
            }
        }
    }
}
