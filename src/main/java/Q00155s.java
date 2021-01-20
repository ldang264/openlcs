import java.util.Stack;

public class Q00155s {

    private Stack<Integer> minStack;

    private Stack<Integer> dataStack;

    /** initialize your data structure here. */
    public Q00155s() {
        minStack = new Stack<>();
        dataStack = new Stack<>();
    }

    public void push(int x) {
        if (minStack.size() == 0) {
            minStack.push(x);
        } else {
            minStack.push(Math.min(minStack.peek(), x));
        }
        dataStack.push(x);
    }

    public void pop() {
        minStack.pop();
        dataStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
