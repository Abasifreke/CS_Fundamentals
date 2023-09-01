package Blind75;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        s = s.toLowerCase();

        int i = 0;
        int j = s.length() - 1;
        for (; i < j;) {
            if(!Character.isAlphabetic(s.charAt(i)) && !Character.isDigit(s.charAt(i))){
                i++;
                continue;
            }
            if(!Character.isAlphabetic(s.charAt(j)) && !Character.isDigit(s.charAt(j))){
                j--;
                continue;
            }

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
