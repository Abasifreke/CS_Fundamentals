package Blind75;

import java.util.HashMap;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        
        assert s != null;
        if(s.length() < 2){
            return s.length();
        }

        int lIndex = 0;
        int rIndex = 0;
        int maxLength = 0;

        HashMap<Character, Integer> uniqueChars = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(!uniqueChars.containsKey(c)){
                uniqueChars.put(c, i);
            }
            else{
                lIndex = Math.max(uniqueChars.get(c) + 1, lIndex);
                uniqueChars.put(c, i);
            }

            rIndex = i + 1;
            if(rIndex - lIndex > maxLength){
                maxLength = rIndex - lIndex;
            }

        }

        return maxLength;
    }
    
}
