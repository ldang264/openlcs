/**
 * 给定一个由若干 0 和 1 组成的数组A，我们最多可以将K个值从 0 变成 1 。
 * 返回仅包含 1 的最长（连续）子数组的长度。
 *
 * 示例 1：
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释： 
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 *
 * 示例 2：
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *
 * 提示：
 *
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] 为0或1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q01004m {
    public int longestOnes(int[] A, int K) {
        int ans = 0, start = 0, end = 0, count = 0;
        while (end < A.length) {
            if (A[end] == 0) { //如果end为0，则计数增加
                ans = Math.max(ans, end - start); // 0的时候必须计算
                count++; // 遇到0计数增加
                while (count > K) { // 当计数超过K时，收缩窗口
                    if (A[start++] == 0) { // 去0
                        count--;
                    }
                }
            }
            end++;
        }
        return Math.max(ans, end - start); // 有可能最后是以1结尾的，没有在if中计算
    }
}
