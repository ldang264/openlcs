import java.util.LinkedList;

/**
 * 给定一个只包含 '('和 ')'的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例1:
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
public class Q00032h {
    public static void main(String[] args) {
        Q00032h lvp = new Q00032h();
        System.out.println(lvp.longestValidParentheses("(()")); // 2
        System.out.println(lvp.longestValidParentheses(")()())")); // 4
        System.out.println(lvp.longestValidParentheses("()(())")); // 6
        System.out.println(lvp.longestValidParentheses("()(()")); // 2
        System.out.println(lvp.longestValidParentheses(")()())")); // 4
        System.out.println(lvp.longestValidParentheses(")()())()()(")); // 4
    }

    public int longestValidParentheses(String s) {
        int ans = 0;
        int temp = 0;
        LinkedList<Boolean> stack = new LinkedList<>(); // true表示(，false表示)
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') { // 入栈
                stack.addLast(true);
            } else { // 消除
                if (stack.size() == 0 || !stack.peekLast()) { // 栈空或栈顶是右字符
                    stack.addLast(false);
                    temp = 0;
                } else { // 栈顶是左字符
                    stack.pollLast();
                    ans = Math.max(ans, ++temp);
                }
            }
        }
        return ans;
    }
}
