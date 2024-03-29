import java.util.LinkedList;

/**
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek返回 -1。
 *
 * 示例1:
 *  输入：
 * ["SortedStack", "push", "push", "peek", "pop", "peek"]
 * [[], [1], [2], [], [], []]
 *  输出：
 * [null,null,null,1,null,2]
 *
 * 示例2:
 *  输入： 
 * ["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
 * [[], [], [], [1], [], []]
 *  输出：
 * [null,null,null,null,null,true]
 *
 * 说明:
 * 栈中的元素数目在[0, 5000]范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-of-stacks-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00003_05m {

    private final LinkedList<Integer> mainStack;

    private final LinkedList<Integer> helpStack;

    public M00003_05m() {
        mainStack = new LinkedList<>();
        helpStack = new LinkedList<>();
    }

    public void push(int val) {
        if (isEmpty() || val <= mainStack.peek()) {
            mainStack.push(val);
            return;
        }
        while (!isEmpty() && val > mainStack.peek()) {
            helpStack.push(mainStack.pop());
        }
        mainStack.push(val);
        while (!helpStack.isEmpty()) {
            mainStack.push(helpStack.pop());
        }
    }

    public void pop() {
        if (!isEmpty())
            mainStack.pop();
    }

    public int peek() {
        return isEmpty() ? -1 : mainStack.peek();
    }

    public boolean isEmpty() {
        return mainStack.size() == 0;
    }
}
