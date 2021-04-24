/**
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。
 * 例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 *
 * 示例 1:
 * 输入: k = 5
 * 输出: 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/get-kth-magic-number-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00017_09m {

    /**
     * 答案：维护一个dp数组和三个下标
     * https://leetcode-cn.com/problems/get-kth-magic-number-lcci/solution/di-k-ge-shu-jiu-shi-xiang-bu-tong-wei-he-san-zhi-z/
     * @param k
     * @return
     */
    public int getKthMagicNumber(int k) {
        int[] dp = new int[k];
        dp[0] = 1;
        int j3 = 0, j5 = 0, j7 = 0;
        for (int i = 1; i < k; i++) {
            int t3 = dp[j3] * 3;
            int t5 = dp[j5] * 5;
            int t7 = dp[j7] * 7;
            dp[i] = Math.min(t3, Math.min(t5, t7));
            if (dp[i] == t3) {
                j3++;
            }
            if (dp[i] == t5) {
                j5++;
            }
            if (dp[i] == t7) {
                j7++;
            }
        }
        return dp[k - 1];
    }
}
