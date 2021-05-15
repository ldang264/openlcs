

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 *
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 *
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00005m {

    /**
     * 动态规划
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        dp[s.length() - 1][s.length() - 1] = true;
        int r = 0, c = 0;
        for (int i = s.length() - 2; i >= 0; i--) { // 从下往上更新
            dp[i][i] = true; // 一个字符肯定是true
            if (s.charAt(i) == s.charAt(i + 1)) {
                if (c - r < 2) {
                    c = i + 1;
                    r = i;
                }
                dp[i][i + 1] = true; // 两个字符判断相等
            }
            for (int j = i + 2; j < s.length(); j++) {
                if (dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) { // 其他情况，判断子状态和两头字符
                    if (c - r < j - i) {
                        c = j;
                        r = i;
                    }
                }
            }
        }
        return s.substring(r, c + 1);
    }
}
