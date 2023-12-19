import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;

/*
    This is a heavily commented java class with two methods for calculating a list of prime numbers less than the input number.
*/
public class PrimeNumbers {

    /*
     * If finding the primes is a very frequent operation, we can potentially keep a
     * precomputed result of primes and the max value of primes calculated for so
     * far to help with caching.
     */

    /*
     * A method that takes a number as input and returns all the prime numbers less
     * than the input number. This method tries checking if every number between the
     * lowest prime (2) to the input number is a prime. It does this by trying to
     * find factors of a given number using the previous numbers in the sequence up
     * to sqrt of i.
     */
    public static List<Integer> calculatePrimesSimple(double inputNumber) {
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i < inputNumber; i++) {
            boolean isPrime = true;
            int sqrtI = (int) Math.sqrt(i);

            // use square root of i because for any i, the factors of i cannot be greater
            // than its square root.
            for (int j = 2; j <= sqrtI; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
            }
        }

        return primes;
    }

    /*
     * A more optimal method that takes a number as input and returns all the prime
     * numbers less than the input number. This method tries checking if every
     * number between the lowest prime (2) to the input number is a prime. It does
     * this by assuming all numbers in the range are primes, and then starting at 2,
     * it goes through the range marking off numbers that are greater than or equal
     * to the square of 2 and are multiples of 2. Then it picks the next unmarked
     * number and does the same... and so on. After this process, we return all
     * unmarked numbers as primes.
     * 
     * This method also validates the input to make sure it isn't negative or in
     * fact less than 2.
     */
    public static List<Integer> calculatePrimesSieve(double inputNumber) throws IllegalArgumentException {
        if (inputNumber < 2) {
            throw new IllegalArgumentException("Invalid input. Provide a number equal to or greater than 2");
        }

        int num = (int) inputNumber;
        boolean[] sieve = new boolean[num];
        List<Integer> primes = new ArrayList<>();

        // assume all prime in sieve
        Arrays.fill(sieve, true);

        int sqrtNum = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrtNum; i++) {
            if (sieve[i]) {
                for (int j = i * i; j < num; j += i) {
                    sieve[j] = false;
                }
            }
        }

        for (int i = 2; i < num; i++) {
            if (sieve[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

    public static void main(String[] args) {

        // Test cases
        // System.out.println("Prime numbers smaller than " + 0 + ": " +
        // calculatePrimesSimple(0));

        // should return empty
        System.out.println("Prime numbers smaller than " + -2 + ": " + calculatePrimesSimple(-2));

        // should return [2,3,5]
        System.out.println("Prime numbers smaller than " + 6.5 + ": " + calculatePrimesSimple(6.5));

        // should return 2, 3, 5, 7
        System.out.println("Prime numbers smaller than " + 10 + ": " + calculatePrimesSimple(10));

        // Allow user input?
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number: ");
        Scanner myObj = new Scanner(System.in);
        while (true) {
            try {
                int input = sc.nextInt();

                // should keep asking for user input till it's valid.
                System.out.println("Prime numbers smaller than " + input + ": " + calculatePrimesSieve(input));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid positive integer.");
                sc.nextLine();
            }
        }

        sc.close();
        System.out.println("----END----");

    }
}
