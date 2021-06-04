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
        LinkedList<Character> symbolList = new LinkedList<>(); // 符号列表
        LinkedList<Integer> digitList = new LinkedList<>(); // 数字列表
        LinkedList<Character> scList = new LinkedList<>();
        LinkedList<Integer> dcList = new LinkedList<>(); // 计算表
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (c == ')') { // 右括号
                char f;
                while ((f = symbolList.removeLast()) != '(') {
                    scList.addFirst(f);
                    dcList.addFirst(digitList.removeLast());
                }
                // 计算弹出的数据
                dcList.addLast(num);
                num = dcList.removeFirst();
                while (dcList.size() > 0) {
                    if (scList.removeFirst() == '+') {
                        num += dcList.removeFirst();
                    } else {
                        num -= dcList.removeFirst();
                    }
                }
            } else if (c >= '0' && c <= '9') { // 数字，需要拼接
                num = num * 10 + (c - '0');
            } else if (c == '(') {
                symbolList.addLast(c);
            } else { //（+-直接入栈
                digitList.addLast(num);
                num = 0;
                symbolList.addLast(c);
            }
        }
        digitList.addLast(num);
        num = digitList.removeFirst();
        while (symbolList.size() > 0) {
            if (symbolList.removeFirst() == '+') {
                num += digitList.removeFirst();
            } else {
                num -= digitList.removeFirst();
            }
        }
        return num;
    }
}
