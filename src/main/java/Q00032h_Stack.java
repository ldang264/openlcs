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

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 作者：LeetCode-Solution
 链接：https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Q00032h_Stack {
    public static void main(String[] args) {
        Q00032h_Stack lvp = new Q00032h_Stack();
        System.out.println(lvp.longestValidParentheses("(()")); // 2
        System.out.println(lvp.longestValidParentheses(")()())")); // 4
        System.out.println(lvp.longestValidParentheses("()(())")); // 6
        System.out.println(lvp.longestValidParentheses("()(()")); // 2
        System.out.println(lvp.longestValidParentheses(")()())")); // 4
        System.out.println(lvp.longestValidParentheses(")()())()()(")); // 4
    }

    public int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

}
