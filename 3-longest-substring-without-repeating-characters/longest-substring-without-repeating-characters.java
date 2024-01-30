class Solution {
    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        Map<Character, Integer> counter = new HashMap<>();
        int maxLength = 0; 

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            while(counter.containsKey(c)){
                char leftC = s.charAt(left);
                counter.put(leftC, counter.get(leftC) - 1);

                if(counter.get(leftC) == 0) counter.remove(leftC);

                left++;
            }

            counter.put(c, 1);
            maxLength = Math.max(maxLength, i - left + 1);
        }

        return maxLength;
    }
}