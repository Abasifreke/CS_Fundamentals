class Solution {
    public boolean isLongPressedName(String name, String typed) {
        /*
            alex
               2
            aaleelx
                2
        */
        if(name.length() > typed.length()) return false;
        if(name.length() == typed.length()) return name.equals(typed);
        
        int j = 0;
        int i = 0;
        for( ;i < name.length() && j < typed.length(); ){
            char nameC = name.charAt(i);
            char typedC = typed.charAt(j);
            
            if(nameC == typedC){
                i++; j++;
            } else{
                if(i == 0 || typedC != name.charAt(i-1)) return false;
                j++;
            } 
        }

        if(i != name.length()) return false;

        while(j < typed.length()){
            if(name.charAt(i-1) != typed.charAt(j)) return false;
            j++;
        }
        
       
       return true;
    }
}