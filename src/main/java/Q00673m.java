/**
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 *
 * 示例 1:
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 *
 * 示例 2:
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 *
 * 注意:给定的数组长度不超过 2000 并且结果一定是32位有符号整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00673m {

    /**
     * 参考了答案
     * @param nums
     * @return
     */
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 1;
        int[] dp = new int[nums.length];
        int[] na = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            na[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    int curr = dp[j] + 1;
                    if (dp[i] < curr) { // 更新长度
                        dp[i] = curr;
                        na[i] = na[j]; // 只能贡献na[j]自身的个数
                    } else if (dp[i] == curr) { // 恰好相等
                        na[i] += na[j]; // na[j]自身所有的个数都可以贡献
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == max) {
                ans += na[i];
            }
        }
        return ans;
    }
}
