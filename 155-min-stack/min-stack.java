class MinStack {
    /*
        [
            
            {-3, -3}
            {0, -2}
            {-2, -2}


            {-3}   
            {0}   {-3}
            {-2} {-2}
        ]

    */

    private Stack<Integer> main;
    private Stack<Integer> minTracker;

    public MinStack() {
        this.main = new Stack<>();
        this.minTracker = new Stack<>();
    }
    
    public void push(int val) {
        main.push(val);

        if(minTracker.isEmpty() || minTracker.peek() >= val){
            minTracker.push(val);
        }
    }
    
    public void pop() { // throw instead on error? 
        if(!main.isEmpty()){
            int val = main.pop();

            if(val == minTracker.peek()){
                minTracker.pop();
            }
        }
    }
    
    public int top() {
        return main.peek();
    }
    
    public int getMin() {
        return minTracker.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */