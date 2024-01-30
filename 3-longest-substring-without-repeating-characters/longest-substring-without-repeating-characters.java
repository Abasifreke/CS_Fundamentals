class Solution {
    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        Map<Character, Integer> counter = new HashMap<>();
        int maxLength = 0; 

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(counter.containsKey(c)){
                left = Math.max(left, counter.get(c) + 1);
            }

            counter.put(c, i);
            maxLength = Math.max(maxLength, i - left + 1);
        }

        return maxLength;
    }
}