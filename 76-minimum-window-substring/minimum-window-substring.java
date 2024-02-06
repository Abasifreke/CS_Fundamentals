class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        for(char c: t.toCharArray()){
            tMap.putIfAbsent(c, 0);
            tMap.put(c, tMap.get(c) + 1);
            sMap.putIfAbsent(c, 0);
        }

        int have = 0, left = 0, right = 0, minLeft = 0, minRight = m + 1;

        for(; right < m; ){
            char rightChar = s.charAt(right);

            if(sMap.containsKey(rightChar)){
                if(sMap.get(rightChar) < tMap.get(rightChar)){
                    have++;
                }
                sMap.put(rightChar, sMap.get(rightChar) + 1);
            }
            right++;

            while(left < right && have == n){
                if(minRight - minLeft > right - left){
                    minRight = right;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                if(sMap.containsKey(leftChar)){
                    if(sMap.get(leftChar) <= tMap.get(leftChar)){
                        have--;
                    }
                    sMap.put(leftChar, sMap.get(leftChar) - 1);
                }
                left++;
            }
        }
       
        return minRight == m+1 ? "": s.substring(minLeft, minRight);
    }
}