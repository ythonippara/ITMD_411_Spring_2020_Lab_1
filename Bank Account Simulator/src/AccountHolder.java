/**
 * The AccountHolder class simulates a bank account.
 * @author Yulia Thonippara (A20411313)
 * Created for ITMD 411 Spring 2020
 */

public class AccountHolder {
	
	// Declare class fields
	private String name; // Account Holder name
	private long accountID;
	private double balance; // Account balance
	public double annualInterestRate;
	
	// No-args constructor
	public AccountHolder() {
		// Set member field to a starter value
		name = " ";
		accountID = 0L;
		balance = 0.0;
	}
	
	// Constructor that accepts an argument
	public AccountHolder(String name, long accountID, double initialBalance) {
		// CEO
		this.name = name;
		this.accountID = accountID;
		balance = initialBalance < 0 ? 0: initialBalance;
	}

	// Mutator methods
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAccountID(long accountID) {
		this.accountID = accountID;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void setAnnualInterestRate(double rate) {
		annualInterestRate = rate;
	}
	
	// Accessor methods
	public String getName() {
		return name;
	}
	
	public long getAccountID() {
		return accountID;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	
	/**
     * Deposits money into the bank account.
     * @param amount the amount to deposit
     */
	public void deposit(double amount) {
		if (amount <= 0)
			System.out.println("Transaction failed. Please enter a positive value.");
		else {
			balance += amount;
			System.out.printf("$%.2f was succesfully deposited to your account.", amount);
		}
	}
	
	/**
     * Withdraws money from the bank account.
     * @param amount the amount to withdraw
     */
	public void withdrawal(double amount) {
		if (amount <= 0)
			System.out.println("Transaction failed. Please enter a positive value.");
		// Check current balance against the withdrawal amount
		else if (balance < amount || (balance - amount) < 50) {
			System.out.println("There are not enough funds to complete this transaction!");
			System.out.println("The current balance of at least $50.00 is required to avoid account maintance fees.");
		}
		else {
			balance -= amount;
			System.out.printf("$%.2f was succesfully withdrawn from your account.", amount);
		}
	}
	
	/**
     *Calculates monthly interest rate
     */
	public double getMonthlyInterestRate() {
		double monthlyInterestRate = ((annualInterestRate/100)/12);
		return monthlyInterestRate;
	}
	
	/**
     *Calculates monthly interest amount
     */
	public double getMonthlyInterest() {
		double monthlyInterest = balance * getMonthlyInterestRate();
		return monthlyInterest;
	}
	
	/**
     *Displays basic account information in a string format.
     *I'm using this method for testing mostly
     */
	public String toString() {
		return ("Hello "  + name + ", your account# " + accountID + " has a current balance of $" + balance);
	}
	
} // End class AccountHolder
