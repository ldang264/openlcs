/**
 * 给定一个只包含 '('和 ')'的字符串，找出最长的包含有效括号的子串的长度。
 *  
 * 示例1:
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 *
 * 示例 2:
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * 示例 3：
 * 输入：s = ""
 * 输出：0
 *
 * 提示：
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00032h {

    public int longestValidParenthesesDp(String s) {
        if (s.length() < 2) return 0;
        int[] dp = new int[s.length()];
        int ans = 0, j;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') { // 如果前一个字符就是左括号，则与dp[i-1]连成更长的有效括号
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if ((j = i - dp[i - 1] - 1) >= 0 && s.charAt(j) == '(') { // 如果i-dp[i-1]-1那个字符是左括号，则与它连成更长的有效括号
                    dp[i] = (j >= 1 ? dp[j - 1] : 0) + dp[i - 1] + 2;
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }

    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        char[] sa = new char[s.length()];
        int ans = 0, sum = 0, index = 0, start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                sa[index] = c;
                start = index++; // 更新(出现的位置
            } else {
                boolean find = false;
                for (int j = start; j >= end; j--) { // 从start找到end即可
                    if (sa[j] == '(') {
                        sa[j] = '*'; // 相等于消除一个(
                        start = j - 1; // 更新(出现的位置
                        find = true;
                        break;
                    }
                }
                if (!find) {
                    sa[index++] = ')';
                    end = index; // end是最后一个)出现的位置的下一个
                }
            }
        }
        for (int i = 0; i < index; i++) {
            if (sa[i] == '*') {
                sum++;
            } else {
                ans = Math.max(ans, sum);
                sum = 0;
            }
        }
        return Math.max(ans, sum) * 2;
    }
}
