import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

    public static void main(String[] args) {

        Random rand = new Random();
        int[] randomNumbers = new int[20];

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = rand.nextInt(10000);
        }

        boolean swappedSomething = true;
        int end = randomNumbers.length - 1;

        while (swappedSomething) {
            swappedSomething = false;
            // bubble sort
            for (int j = 0; j < end; j++) {
                if (randomNumbers[j] > randomNumbers[j + 1]) {
                    // swap
                    randomNumbers[j] = randomNumbers[j] + randomNumbers[j + 1];
                    randomNumbers[j + 1] = randomNumbers[j] - randomNumbers[j + 1];
                    randomNumbers[j] = randomNumbers[j] - randomNumbers[j + 1];
                    swappedSomething = true;
                }
            }
            end--;
        }

        System.out.println(Arrays.toString(randomNumbers));
    }

}
