import java.util.Arrays;

/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 * 示例 1:
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 *
 * 示例 2:
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 *
 * 限制：
 * 1 <= n <= 11
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class J00060m {
    /**
     * 1 1 1 1 1 1
     *   2
     * @param n
     * @return
     */
    public double[] dicesProbability(int n) {
        int[] prev = new int[7];
        int[] next = new int[13];
        Arrays.fill(prev, 1, 7, 1);
        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j <= (i - 1) * 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    next[j + k] += prev[j];
                }
            }
            prev = next;
            next = new int[next.length + 6];
        }
        int sum = 0;
        for (int num : prev) {
            sum += num;
        }
        double[] ans = new double[5 * n + 1];
        for (int i = n; i < prev.length; i++) {
            ans[i - n] = 1.00000 * prev[i] / sum;
        }
        return ans;
    }
}
