/**
 * 给两个整数数组A和B，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例：
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 *
 * 提示：
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00718m {
    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1]; // 表示A[i] == B[j]的公共子串的长度
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) { // 如果相等，取前一个dp的长度+1
                    ans = Math.max(ans, dp[i + 1][j + 1] = dp[i][j] + 1);
                }
            }
        }
        return ans;
    }

    /**
     * 暴力法
     * @param A
     * @param B
     * @return
     */
    public int findLength1(int[] A, int[] B) {
        int ans = 0;
        for (int i = 0; i < A.length - ans; i++) {
            for (int j = 0; j < B.length - ans; j++) {
                if (A[i] == B[j]) { // 找到了起始点
                    int len = 0;
                    int m = i, n = j;
                    while (m < A.length && n < B.length) {
                        if (A[m] != B[n]) break;
                        len++;
                        m++;
                        n++;
                    }
                    ans = Math.max(ans, len);
                }
            }
        }
        return ans;
    }
}
