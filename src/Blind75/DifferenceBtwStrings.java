package Blind75;

import java.io.*;
import java.util.*;

class DifferenceBtwStrings {

    static String[] diffBetweenTwoStringsBottomUp(String source, String target) {
        // your code goes here

        int m = source.length();
        int n = target.length();

        // Initialize a DP table to store the minimum edits.
        int[][] dp = new int[m + 1][n + 1];

        // Fill in the DP table.
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (source.charAt(i - 1) == target.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        // Reconstruct the edit sequence.
        List<String> result = new ArrayList<>();
        int i = m, j = n;
        while (i > 0 || j > 0) {
            if (i > 0 && dp[i][j] == dp[i - 1][j] + 1) {
                result.add("-" + source.charAt(i - 1));
                i--;
            } else if (j > 0 && dp[i][j] == dp[i][j - 1] + 1) {
                result.add("+" + target.charAt(j - 1));
                j--;
            } else {
                result.add(String.valueOf(source.charAt(i - 1)));
                i--;
                j--;
            }
        }
        // Reverse the result to get the correct order.
        Collections.reverse(result);
        return result.toArray(new String[result.size()]);
    }

    // static String[] diffBetweenTwoStrings(String source, String target) {
    // Map<String, List<String>> map = new HashMap<>();
    // List<String> result = diffBetweenTwoStringsHelper(source, target, map);
    // System.out.println(result);
    // return result.toArray(new String[result.size()]);
    // }
    public static String[] diffBetweenTwoStrings(String source, String target) {
        Map<String, List<String>> memo = new HashMap<>();
        List<String> result = diffBetweenTwoStringsHelper(source, target, memo);
        return result.toArray(new String[result.size()]);
    }

    private static List<String> diffBetweenTwoStringsHelper(String source, String target,
            Map<String, List<String>> memo) {
        String key = source + "|" + target;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        List<String> result = new ArrayList<>();

        if (source.equals(target)) {
            return result;
        }

        if (source.isEmpty()) {
            for (char ch : target.toCharArray()) {
                result.add("+" + ch);
            }
            return result;
        }

        if (target.isEmpty()) {
            for (char ch : source.toCharArray()) {
                result.add("-" + ch);
            }
            return result;
        }

        if (source.charAt(0) == target.charAt(0)) {
            result.add(String.valueOf(source.charAt(0)));
            List<String> subResult = diffBetweenTwoStringsHelper(source.substring(1), target.substring(1), memo);
            result.addAll(subResult);
        } else {
            List<String> option1 = new ArrayList<>(result);
            option1.add("+" + target.charAt(0));
            List<String> subResult1 = diffBetweenTwoStringsHelper(source, target.substring(1), memo);
            option1.addAll(subResult1);

            List<String> option2 = new ArrayList<>(result);
            option2.add("-" + source.charAt(0));
            List<String> subResult2 = diffBetweenTwoStringsHelper(source.substring(1), target, memo);
            option2.addAll(subResult2);

            if (subResult1.size() <= subResult2.size()) {
                result.addAll(option1);
            } else {
                result.addAll(option2);
            }
        }

        memo.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        String source = "ABCDEFG";
        String target = "ABDFFGH";

        System.out.println(Arrays.toString(diffBetweenTwoStrings(source, target)));
    }
}
/*





*/