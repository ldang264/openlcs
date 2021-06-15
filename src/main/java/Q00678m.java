

/**
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 *
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * 示例 1:
 *
 * 输入: "()"
 * 输出: True
 * 示例 2:
 *
 * 输入: "(*)"
 * 输出: True
 * 示例 3:
 *
 * 输入: "(*))"
 * 输出: True
 * 注意:
 *
 * 字符串大小将在 [1，100] 范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parenthesis-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00678m {
    public boolean checkValidString(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (i < sb.length()) {
            char c = sb.charAt(i);
            if (c == ')') {
                if (i == 0) return false; // 无左括号或星号
                sb.deleteCharAt(i); // 删除右括号
                boolean left = false; // 是否找到左括号
                for (int j = i - 1; j >= 0; j--) {
                    if (sb.charAt(j) == '(') {
                        left = true;
                        sb.deleteCharAt(j); // 1.1 有左括号则删除左括号
                        break;
                    }
                }
                if (!left) {
                    sb.deleteCharAt(i - 1); // 1.2 否则删除星号
                }
                i--; // 回拨
            } else {
                i++;
            }
        }
        i = sb.length() - 1;
        int n = 0;
        while (i >= 0) {
            if (sb.charAt(i) == '*') {
                n++;
            } else if (n == 0) { // 左括号没有星号对应
                return false;
            } else { // 用星号抵消
                n--;
            }
            i--;
        }
        return true;
    }
}
