/**
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 *
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 *
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 *
 * 如果不含有 “山脉” 则返回 0。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * 示例 2：
 *
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 *  
 *
 * 提示：
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-mountain-in-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 *
 作者：LeetCode-Solution
 链接：https://leetcode-cn.com/problems/longest-mountain-in-array/solution/shu-zu-zhong-de-zui-chang-shan-mai-by-leetcode-sol/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Q00845m_Ans {
    public static void main(String[] args) {
        Q00845m_Ans lm = new Q00845m_Ans();
        System.out.println(lm.longestMountain(new int[]{2,1,4,7,3,2,5})); // 5
        System.out.println(lm.longestMountain(new int[]{2,1,4,7,3,3,5})); // 4
        System.out.println(lm.longestMountain(new int[]{2,2,4,7,3,3,5})); // 4
        System.out.println(lm.longestMountain(new int[]{2,2,4,7,3,2,5})); // 5
        System.out.println(lm.longestMountain(new int[]{2,1,4,7,3,4,5})); // 4
        System.out.println(lm.longestMountain(new int[]{2,2,2})); // 0
        System.out.println(lm.longestMountain(new int[]{2,1})); // 0
        System.out.println(lm.longestMountain(new int[]{2,3})); // 0
        System.out.println(lm.longestMountain(new int[]{2,3,3})); // 0
        System.out.println(lm.longestMountain(new int[]{2,3,3,3})); // 0
        System.out.println(lm.longestMountain(new int[]{2,3,2})); // 3
        System.out.println(lm.longestMountain(new int[]{2,1,3,2,3,4,3,2})); // 5
        System.out.println(lm.longestMountain(new int[]{2,2,3,4,3,4,3})); // 4
        System.out.println(lm.longestMountain(new int[]{0,1,2,3,4,5,4,3,2,1,0})); // 11
        System.out.println(lm.longestMountain(new int[]{0,1,2,3,4,5})); // 0
        System.out.println(lm.longestMountain(new int[]{5,4,3,2,1,0})); // 0
        System.out.println(lm.longestMountain(new int[]{0,1,0,0,1,0,0,1,1,0,0,0,1,1,0,1,0,1,0,1,0,0,0,1})); // 3
    }

    public int longestMountain(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int[] left = new int[n];
        for (int i = 1; i < n; ++i) {
            left[i] = A[i - 1] < A[i] ? left[i - 1] + 1 : 0;
        }
        int[] right = new int[n];
        for (int i = n - 2; i >= 0; --i) {
            right[i] = A[i + 1] < A[i] ? right[i + 1] + 1 : 0;
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (left[i] > 0 && right[i] > 0) {
                ans = Math.max(ans, left[i] + right[i] + 1);
            }
        }
        return ans;
    }

    public int longestMountain1(int[] A) {
        int n = A.length;
        int ans = 0;
        int left = 0;
        while (left + 2 < n) {
            int right = left + 1;
            if (A[left] < A[left + 1]) {
                while (right + 1 < n && A[right] < A[right + 1]) {
                    ++right;
                }
                if (right < n - 1 && A[right] > A[right + 1]) {
                    while (right + 1 < n && A[right] > A[right + 1]) {
                        ++right;
                    }
                    ans = Math.max(ans, right - left + 1);
                } else {
                    ++right;
                }
            }
            left = right;
        }
        return ans;
    }
}
