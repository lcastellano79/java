import javax.swing.JOptionPane;

// Written by: Larissa Castellano
//______________________________________________________________________________

// This program calculates the quantity of candy bars, free games and remaining coupons based on the inputed amount of coupons  
public class CouponRedeemer {

	public static void main(String[] args) {
        // Display input message box
        String string = JOptionPane.showInputDialog(null,"How many coupons do you have to redeem (enter an integer)? ", "Welcome to Larissa's coupon redeemer!", JOptionPane.QUESTION_MESSAGE);

        // Parse input string into int
        int originalCoupons = Integer.parseInt(string);

        // Answer to question a) there is only one input, the number of coupons, which is an integer, since you cannot have less than one coupon
        // Answer to question b) there are 3 outputs, Candy Bars, Free Games and remaining coupons, and they are integers
        
        // c) The following statement calculates the amount of candy bars
        int candyBars = originalCoupons / 5;
        
        // c) The following statement calculates the amount of free games
        int freeGames = ( originalCoupons % 5) / 3;
        
        // c) The following statement calculates the amount of remaining coupons
        int coupons = originalCoupons - candyBars*5 - freeGames*3;
        
        // d)1 16/5=3 candy bars, 16%5/3=0 free games, 16-15-0=1 remaining coupon
        // d)2 2/5=0 candy bars, 2%5/3=0 free games, 2-0-0=2 remaining coupons
    
        // Display result
        JOptionPane.showMessageDialog(null,"With your winnings you have " +
      candyBars + " Candy Bar(s), " + freeGames + " Free Game(s) and still have "+ coupons + " Coupon(s) left.\n\nHope you enjoy your Candy Bars!" ,"Coupon Redeemer",JOptionPane.INFORMATION_MESSAGE);

	}

}
