import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.concurrent.CyclicBarrier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestClass {
    Customer test; // Create a customer
    Date date; // Create a date

    @Before // Before each test
    public void setup(){
        test = new Customer("Test", 000,  0, 0); // Reset the customers values and define it
    }

    @Test // Test 1
    public void depositToString(){
        date = new Date(10000); // Create a set date
        Deposit deposit1 = new Deposit(100, date, "Checking"); // Create new deposits (Checking)
        Deposit deposit2 = new Deposit(100, date, "Saving"); // Create new deposits (Saving)
        assertEquals("Deposit of: 100.0 Date: Wed Dec 31 16:00:10 PST 1969 into account: Checking", deposit1.toString()); // Call to string on created deposit and compare output with expected output
        assertEquals("Deposit of: 100.0 Date: Wed Dec 31 16:00:10 PST 1969 into account: Saving", deposit2.toString()); // Call to string on created deposit and compare output with expected output
    }

    @Test // Test 2
    public void withdrawToString(){
        date = new Date(10000); // Create a set date
        Withdraw withdraw1 = new Withdraw(100, date, "Checking"); // Create new deposits (Checking)
        Withdraw withdraw2 = new Withdraw(100, date, "Saving"); // Create new deposits (Saving)
        assertEquals("Withdraw of: 100.0 Date: Wed Dec 31 16:00:10 PST 1969 into account: Checking", withdraw1.toString()); // Call to string on created deposit and compare output with expected output
        assertEquals("Withdraw of: 100.0 Date: Wed Dec 31 16:00:10 PST 1969 into account: Saving", withdraw2.toString()); // Call to string on created deposit and compare output with expected output
    }

    @Test // Test 3
    public void customerWithdrawNoOverdraft(){
        assertEquals(0, test.getCheckBalance(), 0); // Check that the checking account has no money
        assertEquals(0, test.getSavingBalance(), 0); // Check that the saving account has no money
        test.deposit(100, date, "Checking"); // Add 100 to checking
        test.deposit(100, date, "Saving"); // Add 100 to saving
        assertEquals(100, test.getCheckBalance(), 0); // Check that the checking account has 100
        assertEquals(100, test.getSavingBalance(), 0); // Check that the saving account has 100
        test.withdraw(100, date, "Checking"); // Withdraw 100 from checking
        test.withdraw(100, date, "Saving"); // Withdraw 100 from saving
        assertEquals(0, test.getCheckBalance(), 0); // Check that the checking account has 0
        assertEquals(0, test.getSavingBalance(), 0); // Check that the saving account has 0
    }

    @Test // Test 4
    public void customerWithdrawOverdraft(){
        assertEquals(0, test.getCheckBalance(), 0); // Check that the checking account has no money
        assertEquals(0, test.getSavingBalance(), 0); // Check that the saving account has no money
        test.withdraw(100, date, "Checking"); // Withdraw 100 from checking
        test.withdraw(100, date, "Saving"); // Withdraw 100 from saving
        assertEquals(-100, test.getCheckBalance(), 0); // Check that the checking account has -100
        assertEquals(-100, test.getSavingBalance(), 0); // Check that the saving account has -100
    }

    @Test // Test 5
    public void customerWithdrawExceedOverdraft(){
        assertEquals(0, test.getCheckBalance(), 0); // Check that the checking account has no money
        assertEquals(0, test.getSavingBalance(), 0); // Check that the saving account has no money
        test.withdraw(100, date, "Checking"); // Withdraw 100 from checking
        test.withdraw(100, date, "Saving"); // Withdraw 100 from checking
        assertEquals(-100, test.getCheckBalance(), 0); // Check that the checking account has -100
        assertEquals(-100, test.getSavingBalance(), 0); // Check that the saving account has -100
        test.withdraw(100, date, "Checking"); // Withdraw 100 from checking
        test.withdraw(100, date, "Saving"); // Withdraw 100 from saving
        assertEquals(-100, test.getCheckBalance(), 0); // Check that balance is still -100
        assertEquals(-100, test.getSavingBalance(), 0);  // Check that the balance is still -100
    }

    @Test // Test 6
    public void customerDeposit(){
        assertEquals(0, test.getCheckBalance(), 0); // Check that the checking account has no money
        assertEquals(0, test.getSavingBalance(), 0); // Check that the saving account has no money
        test.deposit(100, date, "Checking"); // Add 100 to checking
        test.deposit(100, date, "Saving"); // Add 100 to saving
        assertEquals(100, test.getCheckBalance(), 0); // Check that the checking account has 100
        assertEquals(100, test.getSavingBalance(), 0); // Check that the saving account has 100
    }
}
