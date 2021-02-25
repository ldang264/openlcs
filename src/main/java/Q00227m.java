import java.util.LinkedList;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格。 整数除法仅保留整数部分。
 *
 * 示例1:
 * 输入: "3+2*2"
 * 输出: 7
 *
 * 示例 2:
 * 输入: " 3/2 "
 * 输出: 1
 *
 * 示例 3:
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 *
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00227m {
    public int calculate(String s) {
        LinkedList<Boolean> symbolStack = new LinkedList<>(); // true表示+，false表示-
        LinkedList<Integer> numStack = new LinkedList<>();
        int ns = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                if (c == '*' || c == '/') {
                    // 找到下一个符号前，把这串字符串转为 被乘数
                    StringBuilder bcsStr = new StringBuilder();
                    int j = i + 1; // 往后寻找被乘或被除数
                    while (j < s.length()) {
                        if (s.charAt(j) != ' ') {
                            if (!isNum(s.charAt(j))) {
                                break;
                            }
                            bcsStr.append(s.charAt(j));
                        }
                        j++;
                    }
                    i = j - 1; // i直接跳到下一个字符
                    if (c == '*') {
                        ns *= Integer.parseInt(bcsStr.toString());
                    } else {
                        ns /= Integer.parseInt(bcsStr.toString());
                    }
                } else if (c == '+') {
                    symbolStack.addLast(true);
                    numStack.addLast(ns);
                    ns = 0;
                } else if (c == '-') {
                    symbolStack.addLast(false);
                    numStack.addLast(ns);
                    ns = 0;
                } else { // 一定是数字
                    ns = ns * 10 + (c - '0'); // 累加数字
                }
            }
        }
        numStack.addLast(ns); // 先把最后的证书加入栈
        int size = symbolStack.size();
        int ans = numStack.removeFirst();
        while (size-- > 0) {
            int num = numStack.removeFirst();
            if (symbolStack.removeFirst()) {
                ans += num;
            } else {
                ans -= num;
            }
        }
        return ans;
    }

    private boolean isNum(char c) {
        return '0' <= c && c <= '9';
    }
}
