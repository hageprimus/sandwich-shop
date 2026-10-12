package com.pluralsight;
import java.util.Scanner;

public class SaleSystem {
    public static void main(String[] args) {
        //Initialize variables
        double smallSandwich = 5.45;
        double largeSandwich = 8.95;
        double smallLoaded = 1;
        double largeLoaded = 1.75;
        double studentDiscount = 0.1;
        double seniorDiscount = 0.2;
        Scanner myScanner = new Scanner(System.in);

        //Select sandwich size and assign storage variables accordingly
        System.out.println("What size sandwich are you purchasing?");
        System.out.println("INPUT CORRESPONDING NUMBER TO SELECT:");
        System.out.println("(1) - Regular - $" + smallSandwich);
        System.out.println("(2) - Large - $" + largeSandwich);
        int selectedSize = myScanner.nextInt();
        double selectedPrice = selectedSize == 1 ? smallSandwich : largeSandwich;
        double loadUpcharge = selectedSize == 1 ? smallLoaded : largeLoaded;

        //Select if sandwich will be loaded
        myScanner.nextLine();   //Clear buffer
        System.out.println("Would you like a loaded sandwich? The additional charge is $" + loadUpcharge);
        System.out.println("INPUT 'yes' OR 'no' TO SELECT:");
        String selectedLoad = myScanner.nextLine();

        //Select discount, if necessary
        System.out.println("What is your age? Certain age groups recieve a discount.");
        System.out.println("INPUT YOUR AGE AS A NUMBER:");
        int userAge = myScanner.nextInt();
        double finalDiscount = 0;
        if (userAge <= 17) {
            finalDiscount = studentDiscount;
        } else if (userAge >= 65) {
            finalDiscount = seniorDiscount;
        }

        //Calculate final cost
        double finalCost = selectedPrice + (selectedLoad.equals("yes") ? loadUpcharge : 0);
        if (finalDiscount != 0)
            finalCost -= (finalCost * finalDiscount);

        System.out.println("The final cost of your sandwich is: " + finalCost);
    }
}
