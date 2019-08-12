import javax.security.sasl.SaslClient;
import java.util.ArrayList; // Import Arraylist
import java.util.Date; // Import Date

public class Customer {
    /* ---- VARIABLES ---- */
    private int accountNumber; // Private account number
    private ArrayList<Deposit> deposits; // Private Arraylist of deposits
    private ArrayList<Withdraw> withdraws; // Private Arraylist of withdraws
    private double checkBalance; // Customers checking balance
    private double savingBalance; // Customers saving balance
    private String name; // Customers name
    public static final String CHECKING = "Checking"; // String for Checking
    public static final String SAVING = "Saving"; // String for Saving
    private final int OVERDRAFT = -100; // Customers Overdraft limit

    /* ---- CONSTRUCTOR ---- */
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        this.name = name; // Sets this name to input name
        this.accountNumber = accountNumber; // Sets this account number to input account number
        this.checkBalance = checkDeposit; // Sets this checking balance to input balance
        this.savingBalance = savingDeposit; // Sets this saving balance to input balance
        deposits = new ArrayList<>(); // Creates customers ArrayList for deposits
        withdraws = new ArrayList<>(); // Creates customers ArrayList for withdraws
    }

    /* ---- METHODS ---- */

    // Deposit Method
    // Requires: double(amt), date(date), account(string account)
    // Modifies: checkBalance(Add amt), savingBalance(Add amt), deposits(Create new ArrayList entry)
    // Effects: // Creates a new deposit and adds amount to users specified account
    public double deposit(double amt, Date date, String account){
        if(account.equals(CHECKING)){ // If the account selected is Checking
            deposits.add(new Deposit(amt, date, CHECKING)); // Create a new deposit in ArrayList using input values
            checkBalance +=  amt; // Add amount to customers checking balance
        }
        else if(account.equals(SAVING)){ // If the account selected is Saving
            deposits.add(new Deposit(amt, date, SAVING)); // Create a new deposit in ArrayList using input values
            savingBalance += amt;// Add amount to customers saving balance
        }
        return 0;
    }

    // Withdraw Method
    // Requires: double(amt), date(date), account(string account)
    // Modifies: checkBalance(Remove amt), savingBalance(Remove amt), withdraws(Create new ArrayList entry
    // Effects: If withdraw amount does not exceed the overdraft then creates a new withdraw and removed amount from users specified account
    public double withdraw(double amt, Date date, String account){
        if(account.equals(CHECKING) && checkOverdraft(amt, CHECKING)){ // If the account selected is checking and user has not exceeded overdraft(Checked with method)
            withdraws.add(new Withdraw(amt, date, CHECKING)); // Create a new withdraw in ArrayList using input values
            checkBalance -= amt; // Removed amt from checkBalance
        }
        else if(account.equals(SAVING) && checkOverdraft(amt, SAVING)){ // If the account selected is saving and the user has not exceeded overdraft(Checked with method)
            withdraws.add(new Withdraw(amt, date, SAVING)); // Create a new withdraw in ArrayList using input values
            savingBalance -= amt; // Remove amt from saving balance
        }
        return 0;
    }

    // Check Overdraft Method
    // Requires: double(amt), account(string account)
    // Modifies: Nothing
    // Effects: Checks if the amount that the user wants to withdraw exceeds the overdraft limit
    private boolean checkOverdraft(double amt, String account){
        boolean allowWithdraw = false; // Boolean that is returned. Controls if withdraw is allowed or not
        if(account.equals(CHECKING)){ // If the selected account is checking
            if(checkBalance < OVERDRAFT || checkBalance - amt < OVERDRAFT){ // If the current  balance is less than overdraft or the balance after removal of funds is less than overdraft
                allowWithdraw = false; // Do not allow withdraw by setting allowWithdraw to false
                System.out.println("Exceeded Overdraft!"); // Print a message letting user know they exceeded the overdraft
            }
            else { // Otherwise they are allowed to withdraw funds
                allowWithdraw = true; // Set allowWithdraw to true
            }
        }
        else if(account.equals(SAVING)){ // If the selected account is Saving
            if(savingBalance < OVERDRAFT || savingBalance - amt < OVERDRAFT){ // If the current  balance is less than overdraft or the balance after removal of funds is less than overdraft
                allowWithdraw = false; // Do not allow withdraw by setting allowWithdraw to false
                System.out.println("Exceeded Overdraft!"); // Print a message letting user know they exceeded the overdraft
            }
            else { // Otherwise they are allowed to withdraw funds
                allowWithdraw = true; // Set allowWithdraw to true
            }
        }
        return allowWithdraw; // Return the value of allowWithdraw
    }
    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

    /* ---- GETTERS AND SETTERS ---- */
    public double getCheckBalance() {
        return checkBalance;
    }

    public void setCheckBalance(double checkBalance) {
        this.checkBalance = checkBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public ArrayList<Deposit> getDeposits() {
        return deposits;
    }

    public ArrayList<Withdraw> getWithdraws() {
        return withdraws;
    }
}
