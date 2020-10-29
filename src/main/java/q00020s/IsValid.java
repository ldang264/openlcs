package q00020s;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
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
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValid {
    public static void main(String[] args) {
        IsValid iv = new IsValid();
        System.out.println(iv.isValid("()"));
        System.out.println(iv.isValid("()[]{}"));
        System.out.println(iv.isValid("(]"));
        System.out.println(iv.isValid("([)]"));
        System.out.println(iv.isValid("{[]}"));
    }

    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(' ');
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                char l = stack.pop();
                if (c - l != 1 && c - l != 2) {
                    return false;
                }
            }
        }
        return stack.size() == 1;
    }

    public boolean isValid(String s) {
        char[] cs = new char[s.length() + 1];
        int j = 1;
        cs[0] = ' ';
        for (int i=0; i<s.length(); i++) {
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
