package Easy;

import java.util.Arrays;

public class ConcatArray {

    public static int[] concatArray(int[] input) {
        int inputLength = input.length;
        int[] res = new int[2 * inputLength];

        for (int i = 0; i < inputLength; i++) {
            res[i] = input[i];
            res[inputLength + i] = input[i];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(concatArray(new int[] { 1, 2, 3, 5, 7, 7 })));
    }
}
