/**
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * 丑数 就是只包含质因数2、3 和/或5的正整数。
 *
 * 示例 1：
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 *
 * 提示：
 * 1 <= n <= 1690
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00264m {
    public int nthUglyNumber(int n) {
        // 1 * 2, 1 * 3, 1 * 5 = 2
        // 2 * 2, 1 * 3, 1 * 5 = 3
        // 2 * 2, 2 * 3, 1 * 5 = 4
        // 3 * 2, 2 * 3, 1 * 5 = 5
        // 3 * 2, 2 * 3, 2 * 5 = 6
        // 4 * 2, 3 * 3, 2 * 5 = 8
        int[] dp = new int[n];
        dp[0] = 1;
        int n2 = 0, n3 = 0, n5 = 0;
        int t2, t3, t5;
        for (int i = 1; i < n; i++) {
            t2 = dp[n2] * 2;
            t3 = dp[n3] * 3;
            t5 = dp[n5] * 5;
            dp[i] = Math.min(t2, Math.min(t3, t5));
            if (dp[i] == t2) {
                n2++;
            }
            if (dp[i] == t3) {
                n3++;
            }
            if (dp[i] == t5) {
                n5++;
            }
        }
        return dp[n - 1];
    }
}
