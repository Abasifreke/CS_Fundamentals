import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingWithSwap {

    public static int longest_array_equal(int[] A) {
        int maxOfMax = 0;

        int left = 0, right = 0, limit = 3;
        PriorityQueue<int[]> maxCount = new PriorityQueue<>((a, b) -> a[1] > b[1] ? -1 : 1);
        Map<Integer, int[]> countMap = new HashMap<>();

        while (right < A.length) {
            int currRight = A[right];
            if (countMap.containsKey(currRight)) {
                countMap.get(currRight)[1]++;
                maxCount.remove(countMap.get(currRight));
                maxCount.offer(countMap.get(currRight));
            } else {
                int[] intCount = new int[] { currRight, 1 };
                countMap.put(currRight, intCount);
                maxCount.offer(intCount);
            }

            int[] maxRecurring = maxCount.peek();

            // get max
            if ((right - left + 1) - maxRecurring[1] < limit) {
                right++;
            } else if ((right - left + 1) - maxRecurring[1] == limit) {
                maxOfMax = Math.max(maxOfMax, right - left + 1);
                right++;
            } else {
                countMap.get(A[left])[1]--;
                left++;
            }

        }

        return maxOfMax == 0 ? (right - left) : maxOfMax;
    }

    // 3, 3, 2, 1, 2, 2, 9, 3, 3
    public static int getLongestEqual(int target, int[] arr) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        int changeLeft = 3;

        for (; right < arr.length;) {
            if (arr[right] == target) {
                right++;
            } else if (changeLeft > 0) {
                changeLeft--;
                right++;
            } else {
                maxLength = Math.max(maxLength, right - left);
                if (arr[left++] != target) {
                    changeLeft++;
                }
            }

        }

        maxLength = Math.max(maxLength, right - left);
        return maxLength;
    }

    public static void main(String[] args) {
        int[] test1 = new int[] { -9, 8 };
        int[] test2 = new int[] { 1, 1, -10, 3, -10, 3, -10 };
        int[] test3 = new int[] { 2, 3, 3, 3, 3, 1 };
        int[] test4 = new int[] { 3, 3, 2, 1, 2, 2, 9, 3, 3 };

        System.out.println(longest_array_equal(test1));
        System.out.println(longest_array_equal(test2));
        System.out.println(longest_array_equal(test3));
        System.out.println(longest_array_equal(test4));
    }

}
