import java.util.Deque;
import java.util.LinkedList;

/**
 * 实现一个MyQueue类，该类用两个栈来实现一个队列。
 *
 * 示例：
 * MyQueue queue = new MyQueue();
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 *
 * 说明：
 *
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00003_04s {

    private final Deque<Integer> stack, helper;

    /** Initialize your data structure here. */
    public M00003_04s() {
        stack = new LinkedList<>();
        helper = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (stack.size() > 0) {
            helper.push(stack.pop());
        }
        stack.push(x);
        while (helper.size() > 0) {
            stack.push(helper.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.size() == 0;
    }
}
