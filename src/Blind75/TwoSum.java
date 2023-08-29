package Blind75;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> diff = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            diff.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (diff.get(target - nums[i]) != null && diff.get(target - nums[i]) != i) {
                return new int[] { i, diff.get(target - nums[i]) };
            }
        }

        return new int[] { -1, -1 }; // signifies no answer

    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();

        System.out.println(Arrays.toString(ts.twoSum(new int[] { 3, 2, 4 }, 6)));
    }

}
