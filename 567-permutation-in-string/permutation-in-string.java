class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // if(s2.length() < s1.length()) return false;

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        int need = 0, have = 0;
        for(char c : s1.toCharArray()){
            s1Map[c - 'a']++;
            need++;
        }

        int left = 0, right = 0;

        for(; right < s2.length(); ){
            char cRight = s2.charAt(right);
            if(s1Map[cRight - 'a'] > 0){
                s2Map[cRight - 'a']++;

                if(s2Map[cRight- 'a'] <= s1Map[cRight - 'a']){
                    have++;
                }
            }

            right++;

            if(right >= s1.length()){
                if(have == need)return true;

                char cLeft = s2.charAt(left++);
                if(s2Map[cLeft - 'a'] > 0){
                    s2Map[cLeft - 'a']--;

                    if(s2Map[cLeft - 'a'] < s1Map[cLeft - 'a']){
                        have--;
                    }   
                }
            }
        }

        return false;
    }
}