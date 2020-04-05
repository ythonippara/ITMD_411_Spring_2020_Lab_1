/**
 * This program demonstrates the AccountHolder class. 
 * 
 * Concepts used include OOP, static methods, 
 * switch statement, if-else statements,
 * processing keyboard input, do-while loops, 
 * overloading constructors, passing objects as arguments to methods, 
 * type casting, formatting String output, etc.
 * 
 * @author Yulia Thonippara (A20411313)
 * Created for ITMD 411 Spring 2020
 */

import java.util.Scanner;
import java.lang.Math;

public class AccountHolderTest {
	
	public static void menuOptions() {
		// Display menu options
		System.out.println("\nMain Menu:");
		System.out.println("Enter 1 to check current balance");
		System.out.println("Enter 2 to deposit funds");
		System.out.println("Enter 3 to withdraw funds");
		System.out.println("Enter 4 to check monthly interest earned");
		System.out.println("Enter 5 to display end-of-the-month balance");
		System.out.println("Enter 0 to exit the program");
	}
	
	public static boolean checkAnswer(char answer) {
		boolean control = true;
		
		if (answer == 'Y') {
			control = true;
		}
		
		else if (answer == 'N') {
			System.out.printf("Thank you for your business! Goodbye!");
			System.exit(0);
		}
		
		else {
			System.out.println("This is not a valid entry. Please try again.");
		}
		
		return control;
	}
	
	public static void mainMenu(AccountHolder client) {
		
		Scanner input = new Scanner(System.in);
		char answer = ' ';
		
		do {
			menuOptions();
			int choice = input.nextInt();
			
			switch(choice) {
			
			case 1: 
				System.out.printf("%s, your current balance is $%.2f.", client.getName(), client.getBalance());
				break;
			
			case 2: 
				System.out.print("Enter the amount to deposit: ");
				double amount1  = input.nextDouble();
				client.deposit(amount1);
				break;
				
			case 3: 
				System.out.print("Enter the amount to withdraw: ");
				double amount2 = input.nextDouble();
				client.withdrawal(amount2);
				break;
		
			case 4: 
				System.out.printf("The account earned a monthly interest of $%.2f.", client.getMonthlyInterest());
				break;
			
			case 5: 
				System.out.printf("With the current balance of $%.2f and the annual interest rate of %%%.2f, \nyour end-of-the-month balance will be $%.2f.", 
						client.getBalance(), client.getAnnualInterestRate(), (client.getBalance() + client.getMonthlyInterest()));
				break;
		
			case 0:
				System.exit(0);
			} // Close switch statement
			
			System.out.print("\n\nWould you like to make another transaction? Y/N: ");
			answer = input.next().toUpperCase().charAt(0);
			
		} while (checkAnswer(answer) == true); // End while loop
		
		input.close();
	}

	public static void main(String[] args) {
		// Initialize local variables
		String clientName;
		long clientAccountID;
		double initBalance; // initial account balance
		double rate = 4.0; // annual interest rate
		char answer = ' ';
		
		// Create a Scanner object for keyboard input
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to WCC Bank!");
		System.out.printf("Currently, we offer an interest rate of %%%.2f.", rate);
		
		System.out.print("\nAre you an existing customer? Y/N: ");
		answer = input.next().toUpperCase().charAt(0);
		
		do {
			
			if (answer == 'Y') {
			// Call a constructor to create a new AccountHolder object
			AccountHolder existingClient = new AccountHolder("Scrooge McDuck", 1111100000L, 1000.00);
			existingClient.setAnnualInterestRate(rate);
			//System.out.println(existingClient.toString()); break;
			mainMenu(existingClient);
			}
		
			else if (answer == 'N') {
				System.out.println("Follow the prompts below to open an account: ");
			
				// Consume the remaining newline
				input.nextLine();
						
				System.out.print("Enter your full name: ");
				clientName = input.nextLine();
			
				//System.out.println("The initial deposit of at least $50 is required.");
				System.out.print("Enter your initial deposit: ");
				initBalance = input.nextDouble();
			
				clientAccountID = (long) (Math.random()*Math.pow(10,10)); // Generate a random 10 digit number for a unique accountID
			
				//Start Object
				AccountHolder newClient = new AccountHolder();
				newClient.setName(clientName);
				newClient.setAccountID(clientAccountID);
				newClient.setBalance(initBalance);
				newClient.setAnnualInterestRate(rate);
			
				//System.out.println(newClient.toString()); break;
				mainMenu(newClient);
			}
			
			else {
				System.out.println("This is not a valid entry. Goodbye!");
			}
			
		} while (answer == 'Y' || answer == 'N'); // End while loop
		
		input.close();
		
	} // End main()
	
} // End class AccountHolderTest
