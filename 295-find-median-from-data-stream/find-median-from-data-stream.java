class MedianFinder {
    
    private PriorityQueue<Integer> leftHalf;
    private PriorityQueue<Integer> rightHalf; 

    public MedianFinder() {
        this.rightHalf = new PriorityQueue<>();
        this.leftHalf = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(rightHalf.size() == leftHalf.size()){
            leftHalf.offer(num);
            rightHalf.offer(leftHalf.poll());
        }else{
            rightHalf.offer(num);
            leftHalf.offer(rightHalf.poll());
        }
    }
    
    public double findMedian() {
        if(rightHalf.size() > leftHalf.size())
            return rightHalf.peek();
        return (rightHalf.peek() + leftHalf.peek()) * 1.0 /2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */