// Task 1: Loan EMI Calculator
// Saiket Systems Internship
// Student Project

import java.util.Scanner;

public class LoanEMICalculator {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("   LOAN EMI CALCULATOR");
        System.out.println("   Saiket Systems Internship");
        System.out.println("========================================\n");
        
        String ch = "yes";
        while (ch.equals("yes") || ch.equals("y")) {
            try {
                System.out.print("Enter Principal Amount (Rs): ");
                double p = sc.nextDouble();
                
                System.out.print("Enter Annual Interest Rate (%): ");
                double r = sc.nextDouble();
                
                System.out.print("Enter Loan Tenure (months): ");
                int n = sc.nextInt();
                
                // calculate emi
                double emi = calcEMI(p, r, n);
                
                // show results
                showResult(p, r, n, emi);
                
                System.out.print("\nCalculate another EMI? (yes/no): ");
                ch = sc.next();
                System.out.println();
                
            } catch (Exception e) {
                System.out.println("Invalid input! Try again.\n");
                sc.nextLine();
            }
        }
        
        System.out.println("Thank you!");
        System.out.println("#SaiKetSystemsJourney #SaiKetExperience");
        sc.close();
    }
    
    // calculate EMI
    public static double calcEMI(double p, double r, int n) {
        double rate = (r / 12) / 100;
        
        if (rate == 0) {
            return p / n;
        }
        
        // EMI Formula: [P * R * (1+R)^N] / [(1+R)^N - 1]
        double pow = Math.pow(1 + rate, n);
        double emi = (p * rate * pow) / (pow - 1);
        
        return emi;
    }
    
    // display results
    public static void showResult(double p, double r, int n, double emi) {
        double total = emi * n;
        double interest = total - p;
        
        System.out.println("\n========================================");
        System.out.println("         EMI CALCULATION RESULT");
        System.out.println("========================================");
        System.out.printf("Principal Amount:     Rs %.2f\n", p);
        System.out.printf("Interest Rate:        %.2f%% per annum\n", r);
        System.out.printf("Loan Tenure:          %d months (%d years %d months)\n", 
                         n, n/12, n%12);
        System.out.println("----------------------------------------");
        System.out.printf("Monthly EMI:          Rs %.2f\n", emi);
        System.out.printf("Total Amount:         Rs %.2f\n", total);
        System.out.printf("Total Interest:       Rs %.2f\n", interest);
        System.out.println("========================================");
    }
}
