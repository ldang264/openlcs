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
public class Q00845m {
    public static void main(String[] args) {
        Q00845m lm = new Q00845m();
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
        if (A == null || A.length <= 2) {
            return 0;
        }
        int ans = 0;
        int i = 0, j = A.length - 1;
        // 去掉开头非递增的
        while (i < A.length - 1) {
            if (A[i] < A[i+1]) break;
            i++;
        }
        if (i == A.length - 1) {
            return 0;
        }
        // 去掉结尾非递减的
        while (j > 0) {
            if (A[j] < A[j - 1]) break;
            j--;
        }
        if (j - i < 2) {
            return 0;
        }
        boolean findHigh = false;
        int left = i++;
        while (i <= j) {
            if (!findHigh) { // 若未找到山峰
                if (A[i - 1] >= A[i]) { // 若A[i-1]>=A[i]，说明非递增，left移动
                    left = i;
                } else if (A[i] > A[i + 1]) { // 若A[i-1]<A[i]且A[i] > A[i+1]，则找到了山峰
                    findHigh = true;
                }
            } else if (i == j || A[i + 1] >= A[i]) { // 在找到山峰的前提下，如果已经i==j或者A[i + 1] >= A[i]，则表示已经找到了山脚
                ans = Math.max(i + 1 - left, ans);
                left = i; // 将left移动到i位置
                findHigh = false; // 计算后标记为未找到，开启下一轮寻找
            }
            i++;
        }
        return ans;
    }

}
