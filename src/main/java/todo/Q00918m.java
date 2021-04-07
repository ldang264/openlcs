package todo;

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
public class Q00918m {

    public int maxSubarraySumCircular(int[] A) {
        int max = A[0], sum = A[0], dp = A[0]; // 当前最大和，元素当前总和，选取当前元素的最大和
        for (int i = 1; i < A.length; i++) {
            sum += A[i]; // 计算总和
            if (dp > 0) { // 如果前项和为正，则加上当前元素
                dp += A[i];
            } else {
                dp = A[i]; // 否则直接取当前元素
            }
            max = Math.max(max, dp); // 每次计算一次最值
        }
        if (max <= 0) return max; // 如果非正数，则直接返回
        int ans = max; // 备份
        max = dp = - A[0]; // 接下来再取A的所有元素相反数的最大子序和
        for (int i = 1; i < A.length; i++) {
            if (dp > 0) {
                dp -= A[i];
            } else {
                dp = - A[i];
            }
            max = Math.max(max, dp);
        }
        return Math.max(ans, sum + max); // sum + max是表示总和减去最小连续子序和，即为循环的可能的最大和。最后再与正的相比
    }

    /**
     * 本方法稍微简洁一些，但因为提前计算了负的最大值，所以效率低
     * @param A
     * @return
     */
    public int maxSubarraySumCircular1(int[] A) {
        int sum = A[0], pmax = A[0], pdp = A[0], nmax = -A[0], ndp = -A[0];
        for (int i = 1; i < A.length; i++) {
            sum += A[i];
            if (pdp > 0) {
                pdp += A[i];
            } else {
                pdp = A[i];
            }
            pmax = Math.max(pmax, pdp);
            A[i] = - A[i];
            if (ndp > 0) {
                ndp += A[i];
            } else {
                ndp = A[i];
            }
            nmax = Math.max(nmax, ndp);
        }
        return pmax <= 0 ? pmax : (Math.max(A[0], Math.max(pmax, sum + nmax)));
    }

}
