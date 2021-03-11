import java.util.LinkedList;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 示例 1：
 * 输入：s = "1 + 1"
 * 输出：2
 *
 * 示例 2：
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 *
 * 示例 3：
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *
 * 提示：
 * 1 <= s.length <= 3* 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00224h {
    public int calculate(String s) {
        LinkedList<String> stack = new LinkedList<>(); // 字符串栈，后进先出
        LinkedList<String> compStack = new LinkedList<>();
        StringBuilder nsb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                if (c == ')') { // 右括号
                    if (nsb.length() > 0) {
                        compStack.addFirst(nsb.toString());
                        nsb = new StringBuilder();
                    }
                    while (stack.size() > 0) {
                        String a = stack.removeLast();
                        if (a.equals("(")) {
                            break;
                        }
                        compStack.addFirst(a);
                    }
                    // 计算弹出的数据
                    int num;
                    String f = compStack.removeFirst();
                    if (f.equals("-")) {
                        num = - Integer.parseInt(compStack.removeFirst());
                    } else {
                        num = Integer.parseInt(f);
                    }
                    while (compStack.size() > 0) {
                        String symb = compStack.removeFirst();
                        int next = Integer.parseInt(compStack.removeFirst());
                        if (symb.equals("+")) {
                            num += next;
                        } else {
                            num -= next;
                        }
                    }
                    stack.addLast(num + "");
                } else if (c >= '0' && c <= '9') { // 数字，需要拼接
                    nsb.append(c);
                } else { //（+-直接入栈
                    if (nsb.length() > 0) {
                        stack.addLast(nsb.toString());
                        nsb = new StringBuilder();
                    }
                    stack.addLast(c + "");
                }
            }
        }
        if (nsb.length() > 0) {
            stack.addLast(nsb.toString());
        }
        int ans;
        String f = stack.removeFirst();
        if (f.equals("-")) {
            ans = - Integer.parseInt(stack.removeFirst());
        } else {
            ans = Integer.parseInt(f);
        }
        while (stack.size() > 0) {
            String symb = stack.removeFirst();
            int next = Integer.parseInt(stack.removeFirst());
            if (symb.equals("+")) {
                ans += next;
            } else {
                ans -= next;
            }
        }
        return ans;
    }
}
