/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * 返回符合要求的 最少分割次数 。
 *
 * 示例 1：
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将s 分割成 ["aa","b"] 这样两个回文子串。
 *
 * 示例 2：
 * 输入：s = "a"
 * 输出：0
 *
 * 示例 3：
 * 输入：s = "ab"
 * 输出：1
 *
 * 提示：
 * 1 <= s.length <= 2000
 * s 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00132h {

    public int minCut(String s) {
        int end = s.length() - 1;
        if (end == 0) return 0;
        boolean[][] help = new boolean[s.length()][s.length()]; // help[i][j]表示s(i)到s(j)是否是回文
        help[end][end] = true;
        for (int i = end - 1; i >= 0; i--) {
            char c = s.charAt(i);
            help[i][i] = true;
            help[i][i + 1] = c == s.charAt(i + 1);
            for (int j = i + 2; j <= end; j++) {
                help[i][j] = help[i + 1][j - 1] && c == s.charAt(j);
            }
        }
        int[] dp = new int[s.length()]; // dp[i]是到i的分割次数
        dp[0] = 0;
        int temp;
        for (int i = 1; i <= end; i++) {
            if (help[0][i]) { // 0到i都是回文
                dp[i] = 0;
            } else {
                dp[i] = i; // 最多分割i次
                for (int j = 1; j <= i; j++) {
                    if (help[j][i] && dp[i] > (temp = dp[j - 1] + 1)) { // j到i是回文，则dp[i]是dp[j - 1] + 1的最小值
                        dp[i] = temp;
                    }
                }
            }
        }
        return dp[end];
    }
}
