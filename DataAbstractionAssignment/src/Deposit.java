import java.util.Date; // Import Date

public class Deposit {
    private double amount; // Amount that is deposited
    private Date date; // Date amount is added
    private String account; // Account that funds are added

    /* ---- CONSTRUCTOR ---- */
    Deposit(double amount, Date date, String account){ // Requires double(amt), date(date) and account(string account)
        this.amount = amount; // Sets this amount to input amount
        this.date = date; // Sets this date to input date
        this.account = account; // Sets this account to input account
        System.out.println(toString()); // Prints the transaction using modified toString
    }

    /* ---- METHODS ---- */
    public String toString(){
        // Returns a string containing all the values in a readable fashion
        return "Deposit of: " + amount + " Date: " + date + " into account: " + account;
    }
}
