package Blind75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> valueToCount = new HashMap<>();

        for (int i : nums) {
            if (!valueToCount.containsKey(i)) {
                valueToCount.put(i, 1);
            } else {
                valueToCount.put(i, valueToCount.get(i) + 1);
            }
        }

        // count to values
        TreeMap<Integer, LinkedList<Integer>> countToNumbers = new TreeMap<>();

        valueToCount.forEach((key, value) -> {
            if (!countToNumbers.containsKey(value)) {
                LinkedList<Integer> countNumbers = new LinkedList<>();
                countNumbers.add(key);
                countToNumbers.put(value, countNumbers);
            } else {

                countToNumbers.get(value).add(key);
            }
        });

        int[] result = new int[k];
        for (int j = 0; j < k;) {
            for (int number : countToNumbers.pollLastEntry().getValue()) {
                result[j] = number;
                j++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements tk = new TopKFrequentElements();

        // int[] input = { 1, 1, 1, 2, 2, 3 };
        int[] input = { 1 };
        int k = 1;

        System.out.println(Arrays.toString(tk.topKFrequent(input, k)));

    }
}
