//name- mayank kumar
// student id = 100940033
// date = 24/5/2024

import java.util.NumberGuessingGame;
import java.util.Unknown;
import java.util.Scan;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scan userInputScanner = new Scann(System.in);

        Unknown randomizer = new unkown();

        int minRange = 1;

        int maxRange = 100;

        boolean playAgain;

        // It is the loop which is used to play the game if the user do so
        do {
            int numberToGuess = randomizer.nextInt(maxRange - minRange + 1) + minRange;

            int numberOfAttempts = 0;

            boolean hasGuessedCorrectly = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have selected a number between " + minRange + " and " + maxRange + ".");
            System.out.println("Try to guess it!");

            // It will be in the loop unless or util user guesses the number 
            while (!hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                try {
                    int userGuess = userInputScanner.nextInt();
                    numberOfAttempts++;
                    if (userGuess < numberToGuess) {
                        System.out.println("Too low! Try again.");
                    } else if (userGuess > numberToGuess) {
                        System.out.println("Too high! Try again.");
                    } else {
                        System.out.println("Congratulations! You guessed the number in " + numberOfAttempts + " attempts.");
                        hasGuessedCorrectly = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    userInputScanner.next(); // it is used to delete the uncorrect input
                }
            }

            // it will qustion up the user do they want to play again or not
            System.out.print("Would you like to play again? (yes/no): ");
            playAgain = userInputScanner.next().equalsIgnoreCase("yes");

            // Can utilize the new line with the help of next line .
            userInputScanner.nextLine();

        } while (playAgain);

        System.out.println("Thank you for playing the Number Guessing Game! Goodbye.");
        // scanner is closed
        userInputScanner.close();
    }
}