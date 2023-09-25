package Blind75;

public class ValidPartition {

    public static boolean validPartition(int[] input) {
        if (input.length < 2) {
            return false;
        }

        if (input.length == 2) {
            return input[0] == input[1];
        }

        boolean[] dp = { false,
                (input[0] == input[1]),
                ((input[1] == input[0] + 1 && input[1] == input[2] - 1)
                        || (input[0] == input[1] && input[1] == input[2])) };

        if (input.length == 3) {
            return dp[2];
        }

        int i = 3;
        while (i < input.length) {
            boolean curr = (input[i] == input[i - 1]) ? dp[1] : false;
            if (curr == false) {
                curr = ((input[i - 1] == input[i - 2] + 1 && input[i] == input[i - 1] + 1) ||
                        (input[i] == input[i - 1] && input[i] == input[i - 2])) ? dp[0] : false;
            }

            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = curr;
            i++;
        }

        return dp[2];

    }

    public static void main(String[] args) {
        // System.out.println(hasValidPartition(new int[] {}));
        // System.out.println(hasValidPartition(new int[] { 1 }));
        // System.out.println(hasValidPartition(new int[] { 1, 2 }));
        // System.out.println(hasValidPartition(new int[] { 1, 2, 3 }));
        // System.out.println(hasValidPartition(new int[] { 2, 2 }));
        // System.out.println(hasValidPartition(new int[] { 2, 2, 3 }));
        System.out.println(validPartition(new int[] { 4, 4, 4, 5, 6, 7, 7, 7, 9,
                2, 3, 4, 5, 6, 7, 6, 6 }));
        System.out.println(validPartition(new int[] { 1, 1, 1, 2 }));
        System.out.println(validPartition(new int[] { 4, 4, 4, 5, 6 }));
    }
}
