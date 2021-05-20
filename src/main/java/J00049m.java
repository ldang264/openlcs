/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 *
 * 1是丑数。
 * n不超过1690。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chou-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class J00049m {
    /**
     * 动态规划
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int f2, f3, f5, n2 = 0, n3 = 0, n5 = 0; // 下标
        for (int i = 1; i < dp.length; i++) {
            f2 = dp[n2] * 2; f3 = dp[n3] * 3; f5 = dp[n5] * 5;
            dp[i] = Math.min(f2, Math.min(f3, f5));
            if (dp[i] == f2) n2++;
            if (dp[i] == f3) n3++;
            if (dp[i] == f5) n5++;
        }
        return dp[n - 1];
    }
}
