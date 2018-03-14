import static java.lang.System.exit;
import javax.swing.JOptionPane;

// Written by: Larissa Castellano 260739557
//______________________________________________________________________________

// This program simulates a department store, for each month of the year, many customers can make purchases, and the program calculates the monthly and total commission for the sales person
public class DepartmentStore {
    
    // Main method
    public static void main(String[] args) {
        
        // Declares the array with the months
        String[] month = {"January","February","March","April","May","June","July","August","September","October","November","December"};
            
        // Declares the variables required to implement the logic
        int customer, purchase, count;
        double transactionAmount, monthlyAmount, totalAmount = 0, monthlyCommission, totalEarnings = 0, partialEarnings = 0;
            
        // Display welcome message and request confirmation to start the program
        int honolulu = JOptionPane.showConfirmDialog(null,"Let's reach the target and go to Honolulu? ", "Welcome to Larissa's Department Store!", JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE);
            
        // Checks if there is a confirmation to run
        if (honolulu == 0)  {
                
            // Repeats the loop for all the months
            for (count=0; count<12; count++)    {
                           
                // Clears the variables, to calculate monthly values
                monthlyAmount = 0;
                monthlyCommission = 0;
                    
                // Sets the condition to run the first loop for each month
                customer = 0;
                    
                // Checks the conditions to allow the sales, there must be a customer, the commission for the month must be lower than $15000 and the total earnings lower than $100000
                while(( customer == 0 ) && (monthlyCommission <= 15000) && (partialEarnings < 100000))  {
                    
                    // Asks if there is a customer
                    customer = JOptionPane.showConfirmDialog(null,"Welcome to " + month[count] + "\nDo we have a customer? ", "Select an option", JOptionPane.YES_NO_CANCEL_OPTION , JOptionPane.QUESTION_MESSAGE);
                        
                    // Checks if there is a customer for this month
                    if (customer == 0)  {
                            
                        // Calculates the random amount for the cost
                        transactionAmount = Math.random() * 50000.0;
                           
                        // Rounds to just 2 decimals    
                        transactionAmount = roundTwoDigits(transactionAmount);         
                            
                        // Asks if the customer wants to confirm the purchase
                        purchase = JOptionPane.showConfirmDialog(null, String.format("Those items cost $%.2f", transactionAmount) + "\nDo you want to confirm the purchase? ", "Purchase Confirmation", JOptionPane.YES_NO_CANCEL_OPTION , JOptionPane.QUESTION_MESSAGE);
                            
                        // Checks if the customer confirmed the purchase
                        if (purchase == 0)  {
                                
                            // Increments the monthly amount of sales
                            monthlyAmount = monthlyAmount + transactionAmount;
                                
                            // If the purchase was not confirmed, presents an informative message informing the purchase was canceled
                        } else    {
                            
                            // Presents an information message, with the cancel information
                            JOptionPane.showMessageDialog(null,"Purchase canceled.","Department Store",JOptionPane.INFORMATION_MESSAGE);
                                
                            // Sets the variable to create a condition to run another purchase at the same month
                            customer = 0;
                        }
              
                    // Calculates the monthy commission
                    monthlyCommission = calcMonthlyComission(monthlyAmount);
                    
                    // Adds the partial earning fo the month to the total earnings to allow the month to end earlier it the $100000 target is reached
                    partialEarnings = totalEarnings + monthlyCommission;

                }  
 
            }
                
            // Calculates the total earnings
            totalEarnings = totalEarnings + monthlyCommission;
                    
            // Checks if the target for the year was reached
            if (totalEarnings > 100000)  {
                        
                // sets the exit condition to the month loop
                count = 12;
                        
                // Presents good bye message
                JOptionPane.showMessageDialog(null,String.format("You reached your target for the year!\nYour total earnings are: $%.2f", totalEarnings) + "\nWelcome to Honolulu!! Enjoy the rest of the year!" , "Department Store",JOptionPane.INFORMATION_MESSAGE);
                    
                // Follow the flow until the month closes           
            }else   { 
                        
                if (count == 11)    {
                    JOptionPane.showMessageDialog(null,"Your total sales for " + month[count] + String.format(" is: $%.2f", monthlyAmount) + String.format("\nYou monthly comission is: $%.2f", monthlyCommission) + String.format("\nYour comission for the year is: $%.2f", totalEarnings) + "\nBetter luck next year!" , "Department Store",JOptionPane.INFORMATION_MESSAGE);
                } else    {
                // Presents message with the summary for the month
                JOptionPane.showMessageDialog(null,"Your total sales for " + month[count] + String.format(" is: $%.2f", monthlyAmount) + String.format("\nYou monthly comission is: $%.2f", monthlyCommission) + String.format("\nYour partial comission for the year is: $%.2f", totalEarnings) + "\nSee you next month!" , "Department Store",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }    
            
        //Presents good bye message and closes the program if there is no confirmation to run
        } else  {
            JOptionPane.showMessageDialog(null,"Thank you for stopping bye.\nSee you next time! Bye bye!!","Department Store",JOptionPane.INFORMATION_MESSAGE);
            exit(0);
        }
    }
        
    // This function rounds a double with 2 decimal digits
    public static double roundTwoDigits(double number)    {

        // Rouds the number with 2 digits
        number = (double)Math.round(number * 100) / 100;

        // Returns rounded number 
        return number;

    }

    // This function calculates the monthly commission according to the incremental commission rates
    public static double calcMonthlyComission(double sales)   {
    
        double commission;

        // For amounts up to $10000, the commission is 10% 
        if( sales >= 10000) {
            commission = 1000;
            // For amounts between 20000 and 30000, the commission is 15% 
            if (sales <= 30000) {
                commission += (sales - 10000) * 0.15;
            
            // For amounts higher than $30000, the commission is 20%
            } else  {
                commission += 2000 + (sales - 30000) * 0.2;
            
            }

        // For amounts up to $10000, the commission is 10%   
        } else     {
            commission = sales * 0.1;
        }

        // Returns the result
        return roundTwoDigits(commission);
    }
    
}