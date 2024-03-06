class Solution {
    public int[] plusOne(int[] digits) {
        
        int rem = 1;
        for(int i = digits.length -1; i >= 0; i--){
            digits[i] += rem;
            rem = digits[i] / 10;
            digits[i] %= 10;
        }
        
        if(rem == 0) return digits;
        
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = rem;
        for(int i = 1; i< newDigits.length; i++){
            newDigits[i] = digits[i-1];
        }
        
        return newDigits;
    }
}