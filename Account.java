package bankaccount;

// Written by: Larissa Castellano
//______________________________________________________________________________


import java.util.Date;

public class Account {

        // Stores the next number to be assigned - default value = 300 (class variable)
	private static int nextAccountNb = 300;	

        // Annual interest rate (class variable)
	private static double annualInterestRate;
        
	// Account Number - cannot be changed
	private final int accounNb;
	
	// First Name
	private String f_name;
	
	// Last Name
	private String l_name;
	
	// Account balance
	private double balance;
	
	// Stores the date when the account was created - cannot be changed
	private final Date dateCreated;
        
        
        // New account constructor
	Account(String firstName, String lastName, double initialBalance)	{
		
            this.accounNb = nextAccountNb++;
       	    this.f_name = firstName;
            this.l_name = lastName;
            this.balance = initialBalance;
            this.dateCreated = new java.util.Date();
            
	}
	
        // Sets the annual interest rate
	void setAnnualInterestRate(double rate)	{
		
		annualInterestRate = rate;
		
	}
        
        // Returns the annual interest rate
	double getAnnualInterestRate()	{
		
		return (annualInterestRate);
		
	}

        // Returns the monthly interest rate
	double getMonthlyInterestRate()	{
		
		return (Account.annualInterestRate / 12);
		
	}
        
        // Returns account number
        int getAccounNb()  {
            return this.accounNb;
        }
        
        // Sets first name
        void setFirstName(String firstName) {
            this.f_name = firstName;
        }
        
        // Returns first name
        String getFirstName()  {
            return this.f_name;
        }
        
        // Sets last name
        void setLastName(String lastName) {
            this.l_name = lastName;
        }
        
        // Returns last name
        String getLastName()  {
            return this.l_name;
        }
        
        // Returns balance
        Double getBalance()  {
            return this.balance;
        }
        
        // Returns account's date of creation
        Date getDateCreated()   {
            return this.dateCreated;
        }
	
        // Withdraws money from the account
	void withdraw(double withdraw)	{
		if ((this.balance - withdraw) >= 0)
			this.balance -= withdraw;
                else
                    System.out.println("Invalid operation");
	}
	
        // Deposits money to the account
	void deposit(double deposito)	{
			this.balance += deposito;
	}
	
}