/**
 * 给你一个整数数组 nums，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释:子数组 [2,3] 有最大乘积 6。
 *
 * 示例 2:
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释:结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00152m {

    /**
     * 逻辑上还是要多加复习
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int[] p_dp = new int[nums.length]; // 最大乘积
        int[] n_dp = new int[nums.length]; // 最小乘积
        int ans = nums[0];
        p_dp[0] = n_dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            p_dp[i] = Math.max(nums[i], Math.max(p_dp[i - 1] * nums[i], n_dp[i - 1] * nums[i])); // 求出最大值
            n_dp[i] = Math.min(nums[i], Math.min(p_dp[i - 1] * nums[i], n_dp[i - 1] * nums[i])); // 求出最小值
            ans = Math.max(ans,  p_dp[i]);
        }
        return ans;
    }
}
