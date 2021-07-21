import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00020s {
    public static void main(String[] args) {
        Q00020s iv = new Q00020s();
        System.out.println(iv.isValid("()"));
        System.out.println(iv.isValid("()[]{}"));
        System.out.println(iv.isValid("(]"));
        System.out.println(iv.isValid("([)]"));
        System.out.println(iv.isValid("{[]}"));
    }

    public boolean isValid1(String s) {
        if ((s.length() & 1) == 1) return false;
        Deque<Character> stack = new LinkedList<>();
        char t;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                t = '(';
            } else if (c == ']') {
                t = '[';
            } else if (c == '}') {
                t = '{';
            } else {
                stack.push(c);
                continue;
            }
            if (stack.size() == 0 || stack.pop() != t) return false;
        }
        return stack.size() == 0;
    }

    public boolean isValid(String s) {
        char[] cs = new char[s.length() + 1];
        int j = 1;
        cs[0] = ' ';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                cs[j++] = c;
            } else {
                char l = cs[--j];
                if (c - l != 1 && c - l != 2) {
                    return false;
                }
            }
        }
        return j == 1;
    }
}
