package MockInterview;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NumberProcessor {

    public static void main(String[] args) {
        String fileName = "numbers.txt";
        List<Integer> numbers = readNumbersFromFile(fileName);
        int sum = calculateSum(numbers);
        List<Integer> primes = findPrimes(numbers);

        System.out.println("Sum: " + sum);
        System.out.println("Prime Numbers: " + primes.toString());
    }

    private static List<Integer> readNumbersFromFile(String fileName) {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName));) {
            String line;
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbers;
    }

    private static int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        return sum;
    }

    private static List<Integer> findPrimes(List<Integer> numbers) {
        List<Integer> primes = new ArrayList<>();
        for (Integer number : numbers) {
            if (isPrime(number)) {
                primes.add(number);
            }
        }
        return primes;
    }

    private static boolean isPrime(int number) {
        if (number < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}
