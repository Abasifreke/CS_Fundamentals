class Solution {
    public int expressiveWords(String s, String[] words) {
        String counts = getLetterWithCount(s);
        // System.out.println(counts);
        int stretchy = 0;
        for(int i=0; i< words.length; i++) {
            if(isStretchy(counts, words[i])) ++stretchy;
        }
        return stretchy;
    }
    
    private boolean isStretchy(String counts, String query) {
        // System.out.println(query);
        int j= 0 , i=0;
        for(; i< counts.length()-1; i+=2) {
            if(j >= query.length()) return false;
            int cc = counts.charAt(i+1)-48;
            char ch = counts.charAt(i), cCh = query.charAt(j);
            // System.out.println(cc+" "+ch+" "+cCh);
            if(cCh != ch) return false;
            
            int count = 0;
            while(j < query.length() && query.charAt(j) == cCh) {
                // System.out.println();
                ++j;  
                ++count;                
            }
            if((cc- count < 0) || (cc -count > 0 && cc <= 2)) return false;                        
        }
        return j == query.length()?true:false;
    }
    
    private String getLetterWithCount(String s) {
        StringBuilder sb = new StringBuilder();        
        char fCh = s.charAt(0); 
        int count = 1;
        for(int i=1; i< s.length(); i++) {
            char cCh = s.charAt(i);
            if(fCh == cCh) {
                ++count;
                continue;
            } 
            sb.append(fCh);
            sb.append(count);
            fCh = cCh;
            count = 1;
        }
        sb.append(fCh);
        sb.append(count);
        return sb.toString();
    }
}