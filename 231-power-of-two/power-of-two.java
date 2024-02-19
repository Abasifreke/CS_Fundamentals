class Solution {
    public boolean isPowerOfTwo(int n) {
      return n > 0 && (1 << 30)%n == 0;

    }
}