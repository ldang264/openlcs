package q00209m;

/**
 * 给定一个含有n个正整数的数组和一个正整数s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 * 示例：
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组[4,3]是该条件下的长度最小的子数组。
 *
 * 进阶：
 * 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinSubArrayLen {

    /**
     * 参考题解
     * 双指针
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int ans = nums.length + 1;
        int sum = 0, start = 0, end = 0;
        while (end < nums.length) {
            sum += nums[end]; // 累加
            while (sum >= s) { // 一旦超过，计算一次，start开始右移，直到再次小于s后，跳出循环，并右移end
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start]; // 减掉移出的start
                start++;
            }
            end++;
        }
        return ans == nums.length + 1 ? 0 : ans;
    }

    /**
     * O(n^2)效率比较低
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen1(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int ans = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0, min = Math.min(ans + i - 1, nums.length), pointer = i;
            while (pointer < min) {
                sum += nums[pointer];
                if (sum >= s) {
                    ans = pointer - i + 1;
                    break;
                }
                pointer++;
            }
        }
        return ans == nums.length + 1 ? 0 : ans;
    }
}
