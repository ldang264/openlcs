/**
 * 三合一。描述如何只用一个数组来实现三个栈。
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 *
 * 示例1:
 *  输入：
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 *  输出：
 * [null, null, null, 1, -1, -1, true]
 * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
 *
 * 示例2:
 *  输入：
 * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 *  输出：
 * [null, null, null, null, 2, 1, -1, -1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-in-one-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00003_01s {

    private final int[] nums; // 存放栈元素

    private final int[] indexes; // 存放每个栈当前最大的下标

    public M00003_01s(int stackSize) {
        nums = new int[stackSize * 3];
        indexes = new int[3];
        indexes[0] = indexes[1] = indexes[2] = -1;
    }

    public void push(int stackNum, int value) {
        if (nums.length == 0) return;
        int index;
        if (indexes[stackNum] < 0) {
            indexes[stackNum] = stackNum;
            nums[stackNum] = value;
        } else if ((index = indexes[stackNum] + 3) < nums.length){
            indexes[stackNum] = index;
            nums[index] = value;
        }
    }

    public int pop(int stackNum) {
        if (nums.length == 0) return -1;
        if (indexes[stackNum] < 0) return -1;
        int index = indexes[stackNum];
        int value = nums[index];
        indexes[stackNum] = index - 3;
        return value;
    }

    public int peek(int stackNum) {
        if (nums.length == 0) return -1;
        return indexes[stackNum] < 0 ? -1 :nums[indexes[stackNum]];
    }

    public boolean isEmpty(int stackNum) {
        return indexes[stackNum] < 0;
    }
}
