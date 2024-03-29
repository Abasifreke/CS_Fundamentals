class Solution {
    public int reverse(int x) {
        int signOfX = Integer.signum(x);
        try {
            int reversedX = signOfX * new Integer(new StringBuilder("" + Math.abs(x)).reverse().toString());
            return reversedX;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}