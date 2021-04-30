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
public class Q00516m_Todo {
    public int longestPalindromeSubseq(String s) {
        // abbab  -> abba
        int[] dp = new int[s.length() + 1]; // dp[i]表示取到第i - 1个字符时，最长回文子序列的长度
        dp[1] = 1;
        return dp[s.length()];
    }
}
