/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 *
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 * 提示：
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 *
 * 进阶：
 * 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00209m {

    /**
     * 滑动窗口
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int ans = nums.length + 1, left = 0, right = 0;
        while (right < nums.length) {
            target -= nums[right]; // 一直减
            if (target <= 0) { // 至少在区间内满足
                while (left <= right && target <= 0) {
                    target += nums[left++]; // 直到target>0
                }
                ans = Math.min(ans, right - left + 2); // 这时，应该是left-1到right是满足的区间
            }
            right++;
        }
        return ans == nums.length + 1 ? 0 : ans;
    }
}
