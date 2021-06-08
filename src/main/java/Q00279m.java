import java.util.Arrays;

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

    private int[] nums;

    public int numSquares(int n) {
        ans = n;
        int sqrt = (int) Math.sqrt(n);
        nums = new int[sqrt];
        for (int i = 1; i <= nums.length; i++) {
            nums[i - 1] = i * i;
        }
        backtrace(n, nums.length - 1, 0);
        return ans;
    }

    private void backtrace(int n, int idx, int count) {
        int y = n % nums[idx];
        count += n / nums[idx];
        if (y != 0) {
            while (y <= n && count < ans) {
                backtrace(y, idx - 1, count);
                y += nums[idx];
                count--;
            }
        } else if (count < ans) {
            ans = count;
        }
    }

    public int numSquares0(int n) {
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
            if (count >= ans) { // 如果当前计数已经超过最小的ans，直接熔断
                break;
            }
            if ((bak %= mn) == 0) {
                ans = count; // 候选值
                break;
            }
            loop(bak, i, count); // 取余作为新的n，递归
            count -= temp; // 递归完减掉计数
        }
    }

    /**
     * 完全背包
     * @param n
     * @return
     */
    public int numSquaresDp(int n) {
        int[] nums = new int[(int) Math.sqrt(n)]; // 存储比n小的完全平方数
        for (int i = 1; i <= nums.length; i++) {
            nums[i - 1] = i * i;
        }
        int[] dp = new int[n + 1]; // 存储从1取到n的个数
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int num = 1; num <= n; num++) {
            for (int sqrt : nums) {
                if (num >= sqrt) {
                    dp[num] = Math.min(dp[num], dp[num - sqrt] + 1);
                }
            }
        }
        return dp[n];
    }

}
