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
               if(l was odd){
                   // find index of odd and remove. 
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

        System.out.println(Arrays.toString(countMap));

        // extracted pairs and left remainders in map
        int totalPairs = 0;
        for(int i = 0; i < 26; i++){
            totalPairs += countMap[i]/2;
            countMap[i] = countMap[i]%2;
        }

        System.out.println(totalPairs);
        System.out.println(Arrays.toString(countMap));
        int maxPals = 0;
        for(String word: words){
            int l = word.length();
            int matchedL = 0;

            matchedL = l/2;
             System.out.println("111 matchedL: " + matchedL + " with totalPairs being " + totalPairs + " and word " + word);
            if(totalPairs < matchedL) break;

            totalPairs -= matchedL;
            // matchedL *= 2;
            // if(l %2 == 1){
            //     for(int i = 0; i < 26; i++){
            //         if(countMap[i] == 1){
            //             matchedL++;
            //             countMap[i] = 0;
            //             break;
            //         }
            //     }
            // }
             System.out.println("matchedL: " + matchedL + " with L being " + l);

            // if(matchedL == l) {
                maxPals++;
            // }

        }

        return maxPals;
    }
}