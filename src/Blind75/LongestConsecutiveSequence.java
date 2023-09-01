package Blind75;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int max, min;
        max = min = nums[0];
        HashSet<Integer> uniqueIntegers = new HashSet<>();

        for (int num : nums) {
            if (num < min) {
                min = num;
            } else if (num > max) {
                max = num;
            }
            uniqueIntegers.add(num);
        }

        int longestSequenceSoFar = 1;
        System.out.println(min + " " + max);
        for (int i = 0; i < nums.length; i++) {
            int lengthOfCurrentSequence = 0;
            int numAtI = nums[i];
            if (!uniqueIntegers.contains(numAtI - 1)) {
                while (uniqueIntegers.contains(numAtI)) {
                    lengthOfCurrentSequence++;
                    numAtI++;
                }
            }
            if (lengthOfCurrentSequence > longestSequenceSoFar) {
                longestSequenceSoFar = lengthOfCurrentSequence;
            }

        }

        return longestSequenceSoFar;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence lcseq = new LongestConsecutiveSequence();

        System.out.println(lcseq.longestConsecutive(new int[] { 3, 2 }));
    }

}
