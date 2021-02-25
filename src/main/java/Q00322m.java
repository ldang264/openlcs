import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
 * 你可以认为每种硬币的数量是无限的。
 *
 * 示例1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 * 示例 2：
 * 输入：coins = [2], amount = 3
 * 输出：-1
 *
 * 示例 3：
 * 输入：coins = [1], amount = 0
 * 输出：0
 *
 * 示例 4：
 * 输入：coins = [1], amount = 1
 * 输出：1
 *
 * 示例 5：
 * 输入：coins = [1], amount = 2
 * 输出：2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00322m {

    private int ans;

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        if (amount == 0) return 0;
        Arrays.sort(coins); // 排个序
        ans = amount + 1;
        find(coins, amount, coins.length - 1, 0);
        return ans == amount + 1 ? -1 : ans;
    }

    private void find(int[] coins, int amount, int index, int count) {
        if (index < 0) return;
        int candidateCount = amount / coins[index];
        if (amount % coins[index] == 0) { // 能整除，直接return
            ans = Math.min(ans, count + candidateCount);
            return;
        }
        if (candidateCount < ans - count) { // 如果当前待加入的个数小于当前最小值与当前计数的差，直接不算了，因为算的个数肯定要比ans多了
            while (candidateCount >= 0) {
                find(coins, amount - candidateCount * coins[index], index - 1, count + candidateCount);
                candidateCount--;
            }
        }
    }
}
