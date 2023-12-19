import java.util.Stack;

public class MinStack {

    /*
     * Min stack
     * integers
     * pop()
     * push()
     * peek()
     * Integer getMin() -> returns smallest min in stack - else null;
     * 1, 2, 3, 0
     * a -> 2, 3, 1, 0, 3
     * list minAttribute = 2, 1, 0,0
     */

    public Stack<Integer> main;
    public Stack<Integer> minStack;

    public MinStack() {
        this.main = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int input) {
        main.push(input);

        if (minStack.isEmpty() ||
                (!minStack.isEmpty() && minStack.peek() > input)) {
            minStack.push(input);
        }
    }


    public Integer peek() {
        return main.peek();
    }

    public Integer pop() {
        if (this.main.isEmpty()) {
            return null;
        }

        int top = main.pop();
        if (top == minStack.peek()) {
            minStack.pop();
        }

        return top;
    }

    public Integer min() {
        return minStack.peek();
    }
}
