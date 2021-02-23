/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *     偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 示例 2：
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * 提示：
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00198m_Ans {

    /**
     * 参考官方答案，动态规划+空间优化
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int prev = nums[0]; // 一间房屋直接偷
        int next = Math.max(nums[0], nums[1]); // 两间房屋偷较大的
        int oldNext;
        for (int i = 2; i < nums.length; i++) {
            oldNext = next;
            next = Math.max(prev + nums[i], next); // 第i间房屋
            prev = oldNext; //
        }
        return next;
    }

    /**
     * 参考官方答案，动态规划
     * @param nums
     * @return
     */
    public int robDp(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0]; // 一间房屋直接偷
        dp[1] = Math.max(nums[0], nums[1]); // 两间房屋偷较大的
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]); // 第i间房屋
        }
        return dp[nums.length - 1];
    }
}
