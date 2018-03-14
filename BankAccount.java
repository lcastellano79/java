
package bankaccount;

import java.util.Scanner;

// Written by: Larissa Castellano
//______________________________________________________________________________


// This program simulates a Bank, allowing account creation, deposits and withdraws
public class BankAccount {

	public static void main(String[] args) {
		
                // Variables declaration
		Scanner input = new Scanner(System.in);
		String firstName, lastName, aux;
		double initialBalance = 100, monthyInterest, ammount;
                int choice = 0;	
		Account bank;
		double interestRate = 4.5;
		
		// Presents welcome message
                System.out.println("Welcome to Larissa's Bank!");
                
                // Presents the interest rate for the day
		System.out.println(String.format("Today's Interest Rate is = %.1f", interestRate) + "%");

                // Colects user information from the console
		System.out.println("\nEnter first name:");
		firstName = input.nextLine();
		System.out.println("Enter last name:");
		lastName = input.nextLine();
		
                // Creates the account
                bank = new Account(firstName, lastName, initialBalance);
                bank.setAnnualInterestRate(interestRate);
                
                // Presents account details
                System.out.println("\n\nYour account details are: ");
                System.out.println("Account number: " + bank.getAccounNb());
                System.out.println("Name is: " + bank.getFirstName() + " " + bank.getLastName() );
                System.out.println("Current balance is $ " + bank.getBalance());
                System.out.println(String.format("Interest Rate is = %.2f", bank.getAnnualInterestRate() ) + "%" );
                monthyInterest = bank.getBalance() * bank.getMonthlyInterestRate() /100;
                System.out.println(String.format("Monthly interest for this balance is: $%.3f", monthyInterest));
                System.out.println("This account was created on: " + bank.getDateCreated());
                
                // Presents and implements the options to deposit, withdaw or quit
                while ( choice != 2)    {
                    System.out.println("\n\nEnter your choice (0: deposit, 1: withdraw, 2: quit):");
                    choice = input.nextInt();
                    if (choice == 0)    {
                        System.out.println("Enter the amount: ");
                        ammount = input.nextDouble();
                        bank.deposit(ammount);
                        System.out.println("Your balance is: " + bank.getBalance());
                    } else if (choice == 1)    {
                        System.out.println("Enter the amount: ");
                        ammount = input.nextDouble();
                        bank.withdraw(ammount);
                        System.out.println("Your balance is: " + bank.getBalance());
                    } else if (choice != 2) {
                        System.out.println("Invalid option!");
                    }
                        
                }
                System.out.println("New balance is: " + bank.getBalance() + "\nBye!!");
	}

}
