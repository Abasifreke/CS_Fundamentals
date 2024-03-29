class Solution {
    public int firstUniqChar(String s) {
        // only supporting lowercase letter per constraints.
        int[] charCount = new int[26]; 

        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (charCount[s.charAt(i) - 'a'] == 1)
                return i;
        }

        return -1;
    }
}