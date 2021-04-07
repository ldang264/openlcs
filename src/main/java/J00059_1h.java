import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7] 
 * 解释: 
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 提示：
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤输入数组的大小。
 *
 * 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class J00059_1h {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>(); // 单调递减队列
        Integer temp;
        for (int i = 0; i < k - 1; i++) {
            while ((temp = queue.peekLast()) != null && nums[i] >= nums[temp]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        for (int i = k - 1; i < nums.length; i++) {
            while ((temp = queue.peekLast()) != null && nums[i] >= nums[temp]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            int start = i - k + 1;
            while (start > (temp = queue.peekFirst())) {
                queue.pollFirst();
            }
            ans[start] = nums[temp];
        }
        return ans;
    }
}
