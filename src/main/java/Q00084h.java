import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为[2,1,5,6,2,3]。
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为10个单位。
 *
 * 示例:
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00084h {

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        int[] right = new int[heights.length]; // 存放右边界
        int[] left = new int[heights.length]; // 存放左边界
        Deque<Integer> stack = new LinkedList<>(); // 单调递增栈
        for (int i = 0; i < heights.length; i++) {
            while (stack.size() > 0 && heights[i] < heights[stack.peek()]) { // 找到了更小的
                right[stack.pop()] = i; // 更新右界，短板就是当前这个i
            }
            if (stack.size() > 0) {
                left[i] = stack.peek() + 1; // 更新左界，左界是比自己小的那个数的右边一个位置
            }
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            ans = Math.max(ans, heights[i] * ((right[i] == 0 ? heights.length : right[i]) - left[i])); // 如果右界等于0，说明没右边有比它小的，那就可以一直扩展到数组的长度
        }
        return ans;
    }
}
