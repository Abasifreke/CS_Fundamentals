class Solution {
    public int expressiveWords(String s, String[] words) {
        // encode words;
        String sEncoded = encode(s);
        String[] wordsEncoded = new String[words.length];
        
        int i = 0;
        for(String w: words){
            wordsEncoded[i++] = encode(w);
        }
        
//         System.out.println(sEncoded);
//         System.out.println(Arrays.toString(wordsEncoded));
        
        int stretchyCount = 0;
        
        for(String we : wordsEncoded){
            // System.out.print("strechy count for " + we + " and " + sEncoded + " is " + isStretch(we, sEncoded));
            stretchyCount += isStretch(we, sEncoded);
        }
        
        return stretchyCount;
    }
    
    public int isStretch(String we, String sEncoded){
        String[] sEncodedParts = sEncoded.split(":");
        String[] weParts = we.split(":");
        
        if(sEncodedParts.length != weParts.length){
            // System.out.println("eject 1");
            return 0;
        }
        
     
        for(int i = 0; i < sEncodedParts.length; i++){
            // System.out.println(sEncodedParts[i]);
            // System.out.println(weParts[i]);
            
            if(!sEncodedParts[i].equals(weParts[i])){
                String[] sEpart = sEncodedParts[i].split("-");
                String[] wePart = weParts[i].split("-");
                int numOfSpart = Integer.parseInt(sEpart[0]);
                int numOfWepart = Integer.parseInt(wePart[0]);
                
                // System.out.println(sEpart[1] + " | " + wePart[1] + " | " + numOfWepart + " | " + numOfSpart);

                if(!sEpart[1].equals(wePart[1]) || numOfWepart > numOfSpart || Math.min(numOfSpart, 3) < 3){
                    // System.out.println(sEpart[1] + " | " + wePart[1] + " | " + numOfWepart + " | " + numOfSpart);
                    //  System.out.println("eject 2");
                    return 0;
                }
            }
        }
        
        return 1;
        
    }
    
    public String encode(String s){
        StringBuilder sb = new StringBuilder();
        if(s.length() == 1){
            return "1-s";
        }
        
        
        int charCount = 1;
        int i = 1;
        for(; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                charCount++;
            }else{
                sb.append(':');
                sb.append(charCount);
                sb.append('-');
                sb.append(s.charAt(i-1));
                charCount = 1;
            }
        }
        sb.append(':');
        sb.append(charCount);
        sb.append('-');
        sb.append(s.charAt(i-1));
        
        return sb.toString();
    }
}