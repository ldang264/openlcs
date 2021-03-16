

/**
 * 给定一个只包含 '('和 ')'的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00032h {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        char[] sa = new char[s.length()];
        int ans = 0, sum = 0, index = 0, start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                sa[index] = s.charAt(i);
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
