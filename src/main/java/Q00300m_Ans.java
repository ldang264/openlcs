

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 * 示例 2：
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 *
 * 示例 3：
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *
 * 提示：
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 * 进阶：
 *
 * 你可以设计时间复杂度为 O(n2) 的解决方案吗？
 * 你能将算法的时间复杂度降低到O(n log(n)) 吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00300m_Ans {

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        int[] dp = new int[nums.length]; // dp[i]表示从0到i的最长子序列的长度
        dp[0] = 1; // 初始化
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1; // 即便是最小的，也应该有1个
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] >= dp[i]) { // 如果nums[i]比nums[j]大，并且dp[j]比dp[i]当前值的子串还长，则更新dp[i]
                    dp[i] = dp[j] + 1;
                }
            }
            ans = Math.max(ans, dp[i]); // 实时计算一次
        }
        return Math.max(ans, dp[0]); // 因为0没比较过
    }
}
