class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        /*     
            abc ab
            a = 2
            b = 2
            c = 1
            ab abc
            
            totalNumOfPairs = n
            for(each word){
               // try to form palindrome
               if(totalNumOfPairs == 0) stop;
               l = word.length
               i = 0;
               while(i <= l/2){
                   // similate getting pair by decreasing totalNumOfPairs by 1;
               }
              
            }
        */

        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int[] countMap = new int[26];
        for(String word: words){
            for(char c: word.toCharArray()){
                countMap[c - 'a']++;
            }
        }

        // extracted pairs and left remainders in map
        int totalPairs = 0;
        for(int i = 0; i < 26; i++){
            totalPairs += countMap[i]/2;
        }
      
        int maxPals = 0;
        for(String word: words){
            int l = word.length();
            int matchedL = l/2;
            if(totalPairs < matchedL) break;

            totalPairs -= matchedL;
            maxPals++;
        }

        return maxPals;
    }
}