package Blind75;

import java.util.Arrays;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);

        if (Arrays.equals(sCharArray, tCharArray)) {
            return true;
        }
        return false;
    }

    public boolean isAnagramEnhanced(String s, String t) {
        int[] asciiChars = new int[128];
        System.out.println(Arrays.toString(asciiChars));

        for (char value : s.toCharArray()) {
            asciiChars[value] += 1;
        }

        for (char value : t.toCharArray()) {
            asciiChars[value] -= 1;
        }

        for (int value : asciiChars) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram vAna = new ValidAnagram();

        String s = "anagram";
        String t = "nagaram";

        System.out.println(vAna.isAnagramEnhanced(s, t));
    }
}
