/**
 * 给定一个由整数数组 A表示的环形数组 C，求 C的非空子数组的最大可能和。
 * 在此处，环形数组意味着数组的末端将会与开头相连呈环状。（形式上，当0 <= i < A.length时C[i] = A[i]，且当i >= 0时C[i+A.length] = C[i]）
 * 此外，子数组最多只能包含固定缓冲区 A中的每个元素一次。（形式上，对于子数组C[i], C[i+1], ..., C[j]，不存在i <= k1, k2 <= j其中k1 % A.length= k2 % A.length）
 *
 * 示例 1：
 * 输入：[1,-2,3,-2]
 * 输出：3
 * 解释：从子数组 [3] 得到最大和 3
 *
 * 示例 2：
 * 输入：[5,-3,5]
 * 输出：10
 * 解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
 *
 * 示例 3：
 * 输入：[3,-1,2,-1]
 * 输出：4
 * 解释：从子数组 [2,-1,3] 得到最大和 2 + (-1) + 3 = 4
 *
 * 示例 4：
 * 输入：[3,-2,2,-3]
 * 输出：3
 * 解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
 *
 * 示例 5：
 * 输入：[-2,-3,-1]
 * 输出：-1
 * 解释：从子数组 [-1] 得到最大和 -1
 *
 * 提示：
 * -30000 <= A[i] <= 30000
 * 1 <= A.length <= 30000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-sum-circular-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00918m_Todo {
    public int maxSubarraySumCircular(int[] A) {
        // 定义dp[i][j]是从i开始的，到j处，以A[j]结尾的最大子数组和的值
        int curr = 0, ans = A[0];
        for (int i = 0; i < A.length; i++) {
            curr = 0;
            for (int j = i; j < A.length; j++) {
                if (curr > 0) {
                    curr += A[j];
                } else {
                    curr = A[j];
                }
                ans = Math.max(ans, curr);
            }
            for (int j = 0; j < i; j++) {
                if (curr > 0) {
                    curr += A[j];
                } else {
                    curr = A[j];
                }
                ans = Math.max(ans, curr);
            }
        }
        return ans;
    }
}
