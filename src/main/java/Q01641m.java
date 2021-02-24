/**
 * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
 * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
 *
 * 示例 1：
 * 输入：n = 1
 * 输出：5
 * 解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
 *
 * 示例 2：
 * 输入：n = 2
 * 输出：15
 * 解释：仅由元音组成的 15 个字典序字符串为
 * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
 * 注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
 *
 * 示例 3：
 * 输入：n = 33
 * 输出：66045
 *
 * 提示：
 *
 * 1 <= n <= 50
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-sorted-vowel-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q01641m {

    /**
     * 进一步简化为两个数组，相邻两行
     * dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * n=1 [1 1 1  1  1]  = 5
     * n=2 [1 2 3  4  5]  = 15
     * n=3 [1 3 6  10 15] = 35
     * n=4 [1 4 10 20 35] = 70
     * @param n
     * @return
     */
    public int countVowelStrings(int n) {
        if (n == 1) return 5;
        int[] dp = new int[5];
        dp[0] = dp[1] = dp[2] = dp[3] = dp[4] = 1; // 第一行都是1
        for (int i = 1; i < n; i++) { // 第i行
            for (int j = 1; j < 5; j++) { // 当前值加上前一个值
                dp[j] += dp[j - 1];
            }
        }
        int sum = 0;
        for (int i = 0; i < 5; i++) { // 最后对dp数组求和
            sum += dp[i];
        }
        return sum;
    }

    /**
     * dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * n=1 [1 1 1  1  1]
     * n=2 [1 2 3  4  5]
     * n=3 [1 3 6  10 15]
     * n=4 [1 4 10 20 35]
     * @param n
     * @return
     */
    /*public int countVowelStrings(int n) {
        if (n == 1) return 5;
        int[][] dp = new int[n - 1][5];
        dp[0][0] = dp[0][1] = dp[0][2] = dp[0][3] = dp[0][4] = 1;
        for (int i = 1; i < n - 1; i++) { // 算到n - 1行
            dp[i][0] = 1;
            dp[i][1] = dp[i][0] + dp[i - 1][1];
            dp[i][2] = dp[i][1] + dp[i - 1][2];
            dp[i][3] = dp[i][2] + dp[i - 1][3];
            dp[i][4] = dp[i][3] + dp[i - 1][4];
        }
        int sum = 0;
        int last = 0;
        for (int i = 0; i < 5; i++) {
            last += dp[n - 2][i];
            sum += last;
        }
        return sum;
    }*/
}
