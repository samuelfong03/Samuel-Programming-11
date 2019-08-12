import java.util.Date; // Import Date

public class Withdraw {
    /* ---- VARIABLES ---- */
    private double amount; // Amount that is removed from account
    private Date date; // Date that withdraw was made
    private String account; // Account that was effected

    /* ---- CONSTRUCTOR ---- */
    Withdraw(double amount, Date date, String account){ // Takes a double, date and account
        this.amount = amount; // Sets this amount to input amount
        this.date = date; // Sets this date to input date
        this.account = account; // Sets this account to input account
        System.out.println(toString()); // Prints the transaction using modified toString
    }

    /* ---- METHOD ---- */
    public String toString(){
        // Returns a string containing all the values in a readable fashion
        return "Withdraw of: " + amount + " Date: " + date + " into account: " + account;
    }
}
