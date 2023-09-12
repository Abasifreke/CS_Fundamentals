package MockInterview;

/**
 * Given a string of length n and a number K ( 0<= K), return if the string
 * can become a palindrome with up to k deletions.
 */
public class PalindromeWithKDeletes {

    public boolean canStringBePalindrome(String s, int k) {

        return canStringBePalindrome(s, k, 0, s.length() - 1);
    }

    private boolean canStringBePalindrome(String s, int k, int start, int end) {

        if (s.length() <= 1 || start == end) {
            return true;
        }

        if (k <= 0) {
            return isPalindrome(s, start, end);
        }

        while (start <= end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                break;
            }
        }

        return canStringBePalindrome(s, k - 1, start, end - 1) || canStringBePalindrome(s, k - 1, start + 1, end);
    }

    private boolean isPalindrome(String s, int start, int end) {

        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeWithKDeletes pd = new PalindromeWithKDeletes();

        System.out.println(pd.canStringBePalindrome("abadssa", 2));
    }

}
