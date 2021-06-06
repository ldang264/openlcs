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
        LinkedList<Integer> list = new LinkedList<>(); // 单调递减
        int idx = 0;
        while (idx < k - 1) { // 先处理k-1个数
            while (list.size() > 0 && nums[idx] >= nums[list.getLast()]) { // 去掉进去相等或者递增的
                list.removeLast();
            }
            list.addLast(idx);
            idx++;
        }
        while (idx < nums.length) {
            while (list.size() > 0 && nums[idx] >= nums[list.getLast()]) { // 去掉进去相等或者递增的
                list.removeLast();
            }
            list.addLast(idx);
            idx++;
            int first = list.getFirst();
            if (idx - k > first) { // 弹出超过起点下标的
                list.removeFirst();
                first = list.getFirst();
            }
            ans[idx - k] = nums[first];
        }
        return ans;
    }

}
