/**
 * 给定正整数n，找到若干个完全平方数（比如1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * 示例1：
 * 输入：n = 12
 * 输出：3 
 * 解释：12 = 4 + 4 + 4
 *
 * 示例 2：
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 * 
 * 提示：
 *
 * 1 <= n <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00279m {

    private int ans;

    public int numSquares(int n) {
        ans = n;
        loop(n, n, 0);
        return ans;
    }

    /**
     * 按照广度优先，从大的平方数向小的平方数找
     * @param n 减掉平方数后的剩余值
     * @param last 被减掉的上一个平方数
     * @param count 当前计数
     */
    private void loop(int n, int last, int count) {
        if (n <= 3) { // 小于等于3是明确的平方数个数
            count += n;
            if (count < ans) {
                ans = count;
            }
            return;
        }
        int max = (int) Math.sqrt(n);
        for (int i = max; i >= 2 && max <= last; i--) { // 遍历2到max.如果当前平方数比上一个平方数大，说明找重了
            int bak = n; // 备份下，因为要修改"n"
            int mn = i * i; // i的平方
            int temp = bak / mn; // 能减掉的i平方的个数
            count += temp; // 加入计数
            if (count > ans) { // 如果当前计数已经超过最小的ans，直接熔断
                break;
            }
            if ((bak %= mn) > 0) { // 取余作为新的n，递归
                loop(bak, i, count);
                count -= temp; // 递归完减掉计数
            } else {
                if (count < ans) { // 候选值
                    ans = count;
                }
                break;
            }
        }
    }
}
