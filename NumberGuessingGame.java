// Task 4: Number Guessing Game
// Saiket Systems Internship
// Student Project

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        System.out.println("========================================");
        System.out.println("   NUMBER GUESSING GAME");
        System.out.println("   Saiket Systems Internship");
        System.out.println("========================================\n");
        System.out.println("Welcome! I'm thinking of a number between 1 and 100.");
        System.out.println("Can you guess it?\n");
        
        int played = 0;
        int won = 0;
        
        while (true) {
            played++;
            boolean win = playGame(sc, rand);
            if (win) {
                won++;
            }
            
            System.out.print("\nPlay again? (yes/no): ");
            String ch = sc.next();
            if (!ch.equalsIgnoreCase("yes") && !ch.equalsIgnoreCase("y")) {
                break;
            }
            System.out.println();
        }
        
        // show stats
        System.out.println("\n========================================");
        System.out.println("         GAME STATISTICS");
        System.out.println("========================================");
        System.out.println("Games Played: " + played);
        System.out.println("Games Won:    " + won);
        if (played > 0) {
            double rate = (won * 100.0) / played;
            System.out.printf("Win Rate:     %.1f%%\n", rate);
        }
        System.out.println("========================================");
        
        System.out.println("\nThanks for playing!");
        System.out.println("#SaiKetSystemsJourney #SaiKetExperience");
        sc.close();
    }
    
    // game logic
    public static boolean playGame(Scanner sc, Random rand) {
        int num = rand.nextInt(100) + 1;
        int tries = 0;
        int max = 10;
        
        System.out.println("I'm thinking of a number between 1 and 100...");
        System.out.println("You have " + max + " attempts to guess it!\n");
        
        while (tries < max) {
            tries++;
            System.out.print("Attempt " + tries + "/" + max + " - Enter your guess: ");
            
            try {
                int guess = sc.nextInt();
                
                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100!\n");
                    tries--;
                    continue;
                }
                
                if (guess == num) {
                    System.out.println("\n*** CONGRATULATIONS! ***");
                    System.out.println("You guessed the number " + num + " correctly!");
                    System.out.println("It took you " + tries + " attempts.");
                    
                    // rating
                    if (tries <= 3) {
                        System.out.println("*** EXCELLENT! You're a genius!");
                    } else if (tries <= 5) {
                        System.out.println("** GREAT! Very good!");
                    } else if (tries <= 7) {
                        System.out.println("* GOOD! Nice job!");
                    } else {
                        System.out.println("Well done!");
                    }
                    return true;
                    
                } else if (guess < num) {
                    int diff = num - guess;
                    if (diff <= 5) {
                        System.out.println("^ Too low, but you're very close!\n");
                    } else if (diff <= 15) {
                        System.out.println("^ Too low! Try a higher number.\n");
                    } else {
                        System.out.println("^ Too low! Way off, go much higher.\n");
                    }
                    
                } else {
                    int diff = guess - num;
                    if (diff <= 5) {
                        System.out.println("v Too high, but you're very close!\n");
                    } else if (diff <= 15) {
                        System.out.println("v Too high! Try a lower number.\n");
                    } else {
                        System.out.println("v Too high! Way off, go much lower.\n");
                    }
                }
                
                // show remaining
                int left = max - tries;
                if (left > 0) {
                    System.out.println("Attempts remaining: " + left);
                }
                
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.\n");
                sc.nextLine();
                tries--;
            }
        }
        
        // game over
        System.out.println("\nX GAME OVER!");
        System.out.println("You've used all " + max + " attempts.");
        System.out.println("The secret number was: " + num);
        System.out.println("Better luck next time!");
        return false;
    }
}
