/**
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 *
 * 示例 1:
 * 输入:
 * "bbbab"
 * 输出:
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 *
 * 示例 2:
 * 输入:
 * "cbbd"
 * 输出:
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 *
 * 提示：
 * 1 <= s.length <= 1000
 * s 只包含小写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00516m {

    /**
     *    b  b  b  a  b
     * b  1  2  3  3  4
     * b     1  2  2  3
     * b        1  1  2
     * a           1  1
     * b              1
     *
     *
     *    a  a  b  a  a
     * a  1  2  2  3  5
     * a     1  1  3  3
     * b        1  1  2
     * a           1  2
     * a              1
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()]; // dp[i][j]表示s(i) 到 s(j)的回文子序列长度
        dp[s.length() - 1][s.length() - 1] = 1;
        for (int i = s.length() - 2; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i + 1][j - 1] + 2 : // 首尾相等，可以加2
                        Math.max(dp[i + 1][j], dp[i][j - 1]); // 不相等，则是前后少一个字符的传递
            }
        }
        return dp[0][s.length() - 1];
    }
}

// dp[i][j] = Math.max(Math.max(dp[i + 1][j - 1] + s.charAt(i) == s.charAt(j) ? 2 : 0, dp[i + 1][j]), dp[i][j - 1]);
