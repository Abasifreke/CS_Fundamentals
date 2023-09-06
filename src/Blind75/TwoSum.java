package Blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public ArrayList<Integer[]> twoSum(int[] nums, int target) {
        Arrays.sort(nums);

        int l = 0;
        int r = nums.length - 1;
        ArrayList<Integer[]> result = new ArrayList<>();

        while (l < r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else if (nums[l] + nums[r] < target) {
                l++;
            } else {
                result.add(new Integer[] { nums[l], nums[r] });
                r--;
                l++;
            }
        }

        return result; // signifies no answer

    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();

        ts.twoSum(new int[] { -2, 0, 1, 1, 2 }, 2).forEach(a -> System.out.println(Arrays.toString(a)));
    }

}
