class Solution {
    public String longestPalindrome(String s) {
        /*

            babadda
            [3, 3, 0, 4 ,]

        */
        // for each char, start from back and look for palidrome. 
        // if found, check size against max so far and set max
        if(s.length() < 2){
            return s;
        }

        String maxSub = "";

        for(int i = 0; i < s.length(); i ++){
            int left = i;
            int right=i;
            // expand middle as much as possible first
            while(right+1 < s.length() && s.charAt(right+1) == s.charAt(right)){
                right++;
            }
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }

            left++;
            right--;
            if(right - left + 1 > maxSub.length()){
                maxSub = s.substring(left, right+1);
            }
        }

        return maxSub;
    }
}