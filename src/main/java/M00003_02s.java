import java.util.Deque;
import java.util.LinkedList;

/**
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 *
 * 示例：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 维护最小值快照
 */
public class M00003_02s {

    private final Deque<Integer> stack, minStack;

    /** initialize your data structure here. */
    public M00003_02s() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) minStack.push(x);
        else minStack.push(Math.min(minStack.peek(), x)); // 存储同期最小值
    }

    public void pop() {
        if (stack.size() > 0) {
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        return stack.size() == 0 ? -1 : stack.peek();
    }

    public int getMin() {
        return minStack.size() == 0 ? -1 : minStack.peek();
    }
}
