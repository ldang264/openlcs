package q00032h;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        LongestValidParentheses lvp = new LongestValidParentheses();
        System.out.println(lvp.longestValidParentheses("(()")); // 2
        System.out.println(lvp.longestValidParentheses(")()())")); // 4
        System.out.println(lvp.longestValidParentheses("()(())")); // 6
        System.out.println(lvp.longestValidParentheses("()(()")); // 2
        System.out.println(lvp.longestValidParentheses(")()())")); // 4
        System.out.println(lvp.longestValidParentheses(")()())()()(")); // 4
    }

    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        char[] sa = new char[s.length()];
        int ans = 0, sum = 0, index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') { // 是(则一直向数组中放
                sa[index++] = s.charAt(i);
            } else { // 否则向前找
                for (int j = index - 1; j>=0; j--) {
                    if (sa[j] == '(') { // 找到(则成对，将其设置为Y
                        sa[j] = 'Y';
                        break;
                    } else if (j == 0) { // 没找到则将)放进数组
                        sa[index++] = ')';
                    }
                }

            }
        }
        // 计算连续个Y的最大长度
        for (int i = 0; i < index; i++) {
            if (sa[i] == 'Y') {
                sum++;
            } else {
                ans = Math.max(ans, sum);
                sum = 0;
            }
        }
        return Math.max(ans, sum) * 2;
    }
}
