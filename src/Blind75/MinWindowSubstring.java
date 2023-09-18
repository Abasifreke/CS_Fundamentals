package Blind75;

import java.util.HashMap;
import java.util.Map;

class MinWindowSubstring {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();
        int needed = t.length();
        int have = 0;
        String minWin = "";

        for (char c : t.toCharArray()) {
            if (!tMap.containsKey(c)) {
                tMap.put(c, 1);
                windowMap.put(c, 0);
            } else {
                tMap.put(c, tMap.get(c) + 1);
            }
        }

        int start = 0;
        int end = 0;

        while (end < s.length()) {
            char endChar = s.charAt(end);
            if (tMap.containsKey(endChar)) {
                windowMap.put(endChar, windowMap.get(endChar) + 1);
                if (windowMap.get(endChar) <= tMap.get(endChar)) {
                    have++;
                }
            }

            while (have == needed) {
                if (minWin.equals("")) {
                    minWin = s.substring(start, end + 1);
                } else if (end - start + 1 < minWin.length()) {
                    minWin = s.substring(start, end + 1);
                }

                char startChar = s.charAt(start);
                if (windowMap.containsKey(startChar)) {
                    if (windowMap.get(startChar) <= tMap.get(startChar)) {
                        have--;
                    }
                    windowMap.put(startChar, windowMap.get(startChar) - 1);
                }
                start++;
            }
            end++;
        }

        return minWin;

    }

    public static void main(String[] args) {
        MinWindowSubstring mw = new MinWindowSubstring();

        String result = mw.minWindow("a", "aa");
        System.out.println(result);

    }
}