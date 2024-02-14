class RLEIterator {
    private int currIndex;
    private int[] encoding;

    public RLEIterator(int[] encoding) {
        this.currIndex = 0;
        this.encoding = encoding;
    }
    
    public int next(int n) {
        int agg = 0;
        while(this.currIndex < this.encoding.length && agg + this.encoding[this.currIndex] < n){
            agg += this.encoding[this.currIndex];
            this.encoding[this.currIndex] = 0;
            this.currIndex += 2;
        }

        if(this.currIndex >= this.encoding.length) return -1;

        this.encoding[this.currIndex] -= (n - agg);
        return this.encoding[this.currIndex + 1];
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */