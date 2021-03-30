/**
 * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00053s {

    /**
     * 标准动态规划
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // 定义dp[i]是以nums[i]结尾的最大子串和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i]; // 当前一定要加上
            if (dp[i - 1] > 0) { // 如果前面的和为正，则加上它的贡献
                dp[i] += dp[i - 1];
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    /**
     * 参考了答案
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int ans = nums[0], sum = 0;
        for (int num : nums) {
            if (sum > 0) { // 前面和是正的，则加上num
                sum += num;
            } else { // 否则用num替代
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
