/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00172s_Ans {

    /**
     * 找规律
     * 比如n是25的倍数，会多一个0
     * 一个数字n表示为1*2*3*4*5*...5k*(5k+i)，首先它会有k个0，其次25,50,75,100等会有多余的0，刚好与k/5的迭代相等
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n >= 5) {
            ans += n /= 5;
        }
        return ans;
    }
}
