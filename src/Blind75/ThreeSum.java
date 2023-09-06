package Blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.HashSet;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> resultSet = new HashSet<>();

        if (nums.length < 3) {
            return null;
        }

        TwoSum t = new TwoSum();

        for (int i = 0; i < nums.length; i++) {

            final int iCopy = i;
            ArrayList<Integer[]> twoSumOfNum = t.twoSum(IntStream.range(0, nums.length)
                    .filter(j -> j != iCopy)
                    .map(j -> nums[j])
                    .toArray(),
                    (nums[i] * -1));
            if (twoSumOfNum.size() != 0) {
                twoSumOfNum.forEach(a -> {
                    List<Integer> triplets = new ArrayList<>();
                    triplets.add(nums[iCopy]);
                    triplets.add(a[0]);
                    triplets.add(a[1]);
                    Collections.sort(triplets);
                    resultSet.add(triplets);
                });
            }
        }

        List<List<Integer>> result = resultSet.stream().toList();

        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();

        ts.threeSum(new int[] { 0, 0, 0 });
    }

}
