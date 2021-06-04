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
 * 提示：
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00227m {
    public int calculate(String s) {
        LinkedList<Boolean> symbolList = new LinkedList<>(); // true表示+，false表示-
        LinkedList<Integer> digitList = new LinkedList<>();
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (c == '*' || c == '/') {
                // 找到下一个符号前，把这串字符串转为 被乘数
                int next = 0;
                while (++i < s.length()) {
                    if (s.charAt(i) != ' ') {
                        if (!Character.isDigit(s.charAt(i))) break;
                        next = next * 10 + (s.charAt(i) - '0');
                    }
                }
                if (c == '*') {
                    prev *= next;
                } else {
                    prev /= next;
                }
                i--; // i回拨
            } else if (c == '+') {
                symbolList.addLast(true);
                digitList.addLast(prev);
                prev = 0;
            } else if (c == '-') {
                symbolList.addLast(false);
                digitList.addLast(prev);
                prev = 0;
            } else { // 一定是数字
                prev = prev * 10 + (c - '0'); // 累加数字
            }
        }
        digitList.addLast(prev); // 先把最后的整数加入栈
        prev = digitList.removeFirst();
        while (symbolList.size() > 0) {
            if (symbolList.removeFirst()) {
                prev += digitList.removeFirst();
            } else {
                prev -= digitList.removeFirst();
            }
        }
        return prev;
    }
}
