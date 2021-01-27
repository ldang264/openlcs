/**
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 * 返回仅包含 1 的最长（连续）子数组的长度。
 * <p>
 * 示例 1：
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * <p>
 * 示例 2：
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] 为 0 或 1 
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 答案
 作者：coldpepsi
 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii/solution/javahua-dong-chuang-kou-by-coldpepsi/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Q01004m_Ans {
    public int longestOnes(int[] A, int K) {
        int count = 0;//统计0的个数
        int left = 0;//滑动窗口区间左端点
        int right = 0;//滑动窗口区间右端点
        int res = 0;//最终结果
        //滑动窗口表示的区间为[left,right)，左闭右开
        while (right < A.length) {
            if (A[right++] == 0) {//窗口扩充一个元素，如果为0则count++；
                count++;
            }
            while (count > K) {//当窗口内0的个数超过k时候，开始收缩窗口
                if (A[left++] == 0) {//如果刚滑出窗口的元素是0，则count--;
                    count--;
                }
            }
            //此时count<=K,保存窗口的最大宽度
            res = Math.max(res, right - left);
        }
        return res;

    }
}
