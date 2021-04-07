/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class J00020m {
    public boolean isNumber(String s) {
        if (s == null || (s = s.trim()).length() == 0) return false; // 空对象或空串
        if (s.charAt(0) == '+' || s.charAt(0) == '-') s = s.substring(1); // 取出开始的加减号
        if (s.equals(".")) return false; // 单独.号
        int dot = -1; // .的下标
        int e = -1; // e的下标
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (Character.isDigit(c)) {
                continue;
            }
            if (c == '.') {
                if (dot >= 0 || (e >= 0 && e < i)) return false; // 不能已经有.或在e后面的
                dot = i;
            } else if (c == '+' || c == '-') {
                // 没有e或者不在e的下一位或者以加减号结尾的
                if (e < 0 || i != (e + 1) || i == (s.length() - 1)) return false;
            } else if (c == 'E' || c == 'e') {
                // 以e开头 或 以e结尾 或 已经存在e 或 以.e开头
                if (e >= 0 || i == 0 || i == (s.length() - 1) || (dot == 0 && i == 1)) return false;
                e = i;
            } else {
                return false; // 非法字符
            }
        }
        return true;
    }
}
