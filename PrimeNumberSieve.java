// Author: Mayank kumar
// Date: 14-06-2024
// Description: This program gives the outputs of prime numbers up to a user-specified
// upper bound using the Sieve of Eratosthenes.

import java.util.Scanner;

public class PrimeNumberSieve {

    public static void main(String[] args) {
        int upperBound = getUpperBound();
        boolean[] primeArray = sieveOfEratosthenes(upperBound);
        printPrimes(primeArray, upperBound);
    }


    //prompt the user for a certain limit and check if the input is correct
    public static int getUpperBound() {
        Scanner scanner = new Scanner(System.in);
        int upperBound = 0;

        while (true) {
            System.out.print("Enter an upper bound (integer between 2 and 1000): ");
            if (scanner.hasNextInt()) {
                upperBound = scanner.nextInt();
                if (upperBound >= 2 && upperBound <= 1000) {
                    break;
                } else {
                    System.out.println("Error: Please enter an integer between 2 and 1000.");
                }
            } else {
                System.out.println("Error: Invalid input. Please enter an integer.");
                scanner.next();
            }
        }

        scanner.close();
        return upperBound;
    }


    //Use the Sieve of Eratosthenes algorithm to get all prime numbers up to the given limit.
    public static boolean[] sieveOfEratosthenes(int upperBound) {
        boolean[] primes = new boolean[upperBound + 1];
        for (int i = 2; i <= upperBound; i++) {
            primes[i] = true;
        }

        for (int p = 2; p * p <= upperBound; p++) {
            if (primes[p]) {
                for (int i = p * p; i <= upperBound; i += p) {
                    primes[i] = false;
                }
            }
        }

        return primes;
    }

    //print the prime numbers using the Sieve of Eratosthenes algorithm.
    public static void printPrimes(boolean[] primes, int upperBound) {
        System.out.println("Prime numbers up to " + upperBound + ":");
        for (int i = 2; i <= upperBound; i++) {
            if (primes[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
