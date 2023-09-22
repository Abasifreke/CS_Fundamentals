package Blind75;

public class MinOpsToReduceX {

    public int minOpsToReduceX(int[] input, int x) {
        int sum = 0;
        for (int y : input) {
            sum += y;
        }

        int targetSum = sum - x;
        int currentSum = 0;
        int maxMidLength = -1;

        for (int i = 0, j = 0; i <= j && j <= input.length - 1; j++) {

            currentSum += input[j];

            while (i <= j && currentSum > targetSum) {
                currentSum -= input[i++];
            }

            if (currentSum == targetSum) {
                maxMidLength = Math.max(j - i + 1, maxMidLength);
            }
        }

        return maxMidLength == -1 ? -1 : input.length - maxMidLength;
    }

    public static void main(String[] args) {
        MinOpsToReduceX m = new MinOpsToReduceX();
        System.out.println(m.minOpsToReduceX(new int[] { 3, 2, 20, 1, 1, 3 }, 10));
        System.out.println(m.minOpsToReduceX(new int[] { 5, 6, 7, 8, 9 }, 4));
        System.out.println(m.minOpsToReduceX(new int[] { 1, 1, 4, 2, 3 }, 5));
    }
}