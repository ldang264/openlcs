import java.util.Deque;
import java.util.LinkedList;

public class Q00155s {

    private final Deque<Integer> minStack;

    private final Deque<Integer> dataStack;

    /** initialize your data structure here. */
    public Q00155s() {
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
        dataStack = new LinkedList<>();
        dataStack.push(0);
    }

    public void push(int x) {
        minStack.push(Math.min(minStack.peek(), x));
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
