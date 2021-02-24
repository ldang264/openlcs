/**
 * 当 A的子数组A[i], A[i+1], ..., A[j]满足下列条件时，我们称其为湍流子数组：
 * 若i <= k < j，当 k为奇数时，A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若i <= k < j，当 k 为偶数时，A[k] > A[k+1]，且当 k为奇数时，A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 *
 * 返回 A 的最大湍流子数组的长度。
 *
 * 示例 1：
 * 输入：[9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 *
 * 示例 2：
 * 输入：[4,8,12,16]
 * 输出：2
 *
 * 示例 3：
 * 输入：[100]
 * 输出：1
 *
 * 提示：
 *
 * 1 <= A.length <= 40000
 * 0 <= A[i] <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-turbulent-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00978m {

    /**
     * 动态规划
     * @param arr
     * @return
     */
    public int maxTurbulenceSize(int[] arr) {
        int ans = 1;
        int evenDp = 1;
        int oddDp = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                oddDp = evenDp + 1;
                ans = Math.max(ans, oddDp);
                evenDp = 1;
            } else if (arr[i] > arr[i - 1]){
                evenDp = oddDp + 1;
                ans = Math.max(ans, evenDp);
                oddDp = 1;
            } else {
                evenDp = 1;
                oddDp = 1;
            }
        }
        return ans;
    }

    /*public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 1) return 1;
        if (arr.length == 2) return arr[0] == arr[1] ? 1 : 2;
        int ans = 0;
        int start = 0;
        int prev = arr[1] - arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            int next = arr[i] - arr[i + 1];
            if (prev == 0) { // 等于前面
                ans = Math.max(ans, i - start);
                start = i;
            } else if (next == 0) { // 等于后面
                ans = Math.max(ans, i - start + 1);
                start = i + 2;
            } else if ((prev > 0 && next < 0) || (prev < 0 && next > 0)) { // 非湍流
                ans = Math.max(ans, i - start + 1);
                start = i;
            }
            prev = -next;
        }
        return Math.max(ans, arr.length - start - (prev == 0 ? 1 : 0));
    }*/
}
