/**
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 *
 * 示例：
 *
 * 输入： [-2,1,-3,4,-1,2,1,-5,4]
 * 输出： 6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶：
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contiguous-sequence-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00016_17s {

    // 同53题和剑指offer42题
    public int maxSubArray(int[] nums) {
        // 定义dp[i]是从选取nums[i]的最大和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] += nums[i]; // 按照定义必选
            if (dp[i - 1] > 0) { // 如果dp[i - 1]贡献为正，则加上
                dp[i] += dp[i - 1];
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
