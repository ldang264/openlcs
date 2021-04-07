import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 *
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 *
 * 示例 3：
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 *
 * 示例 4：
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 *
 * 示例 5：
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 *
 * 提示：
 * 1 <= nums.length <= 105
 * -104<= nums[i] <= 104
 * 1 <= k <= nums.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00239h {

    /**
     * 维护单调递减队列，最大长度为k
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        Integer temp;
        for (int i = 0; i < k - 1; i++) { // 先处理k-1个数
            while ((temp = queue.peekLast()) != null && nums[i] >= nums[temp]) { // 去掉进去相等或者递增的
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        for (int i = k - 1; i < nums.length; i++) {
            while ((temp = queue.peekLast()) != null && nums[i] >= nums[temp]) { // 去掉进去相等或者递增的
                queue.pollLast();
            }
            queue.offerLast(i); // 加入自身
            int start = i - k + 1; // 起点下标
            while (start > (temp = queue.peekFirst())) { // 弹出超过起点下标的
                queue.pollFirst();
            }
            ans[start] = nums[temp]; // 设置起点下标
        }
        return ans;
    }
    /**
     * 暴力解法，容易超时
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int maxIndex = -1;
        for (int i = 0; i < ans.length; i++) {
            if (i > maxIndex) {
                maxIndex = i;
                for (int j = i + 1; j < i + k; j++) {
                    if (nums[j] >= nums[maxIndex]) {
                        maxIndex = j;
                    }
                }
            } else if (nums[i + k - 1] >= nums[maxIndex]) {
                maxIndex = i + k - 1;
            }
            ans[i] = nums[maxIndex];
        }
        return ans;
    }

}
