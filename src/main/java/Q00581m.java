import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 * 示例 1：
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 *
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：0
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出：0
 *
 * 提示：
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 *
 * 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00581m {

    /**
     * 单调栈
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        int min = nums.length;
        for (int i = 1; i < nums.length; i++) { // 从左向右枚举，构造单调递增栈
            while (stack.size() > 0 && nums[stack.peek()] > nums[i]) {
                min = Math.min(min, stack.pop());
            }
            stack.push(i);
        }
        if (min == nums.length) return 0;
        int max = min - 1;
        stack.clear();
        stack.push(nums.length - 1);
        for (int i = nums.length - 2; i >= min; i--) {
            while (stack.size() > 0 && nums[stack.peek()] < nums[i]) { // 从左向右枚举，构造单调递减栈
                max = Math.max(max, stack.pop());
            }
            stack.push(i);
        }
        return max + 1 - min;
    }

}
