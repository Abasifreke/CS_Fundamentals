class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;

        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();
        int need = 0, have = 0;
        for(char c : s1.toCharArray()){
            s1Map.putIfAbsent(c, 0);
            s1Map.put(c, s1Map.get(c) + 1);
            need++;
        }

        int left = 0, right = 0;

        for(; right < s2.length(); ){
            char cRight = s2.charAt(right);
            if(s1Map.containsKey(cRight)){
                s2Map.putIfAbsent(cRight, 0);
                s2Map.put(cRight, s2Map.get(cRight) + 1);

                if(s2Map.get(cRight) <= s1Map.get(cRight)){
                    have++;
                }
            }

            right++;

            if((right-left) == s1.length()){
                if(have == need)return true;

                char cLeft = s2.charAt(left++);
                if(s2Map.containsKey(cLeft) && s2Map.get(cLeft) > 0){
                    s2Map.put(cLeft, s2Map.get(cLeft) - 1);

                    if(s2Map.get(cLeft) < s1Map.get(cLeft)){
                        have--;
                    }   
                }
            }
        }

        return false;
    }
}