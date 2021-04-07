/**
 * 有效数字（按顺序）可以分成以下几个部分：
 *
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 小数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * 部分有效数字列举如下：
 *
 * ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]
 * 部分无效数字列举如下：
 *
 * ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]
 * 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。
 *
 * 示例 1：
 * 输入：s = "0"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "e"
 * 输出：false
 *
 * 示例 3：
 * 输入：s = "."
 * 输出：false
 *
 * 示例 4：
 * 输入：s = ".1"
 * 输出：true
 *
 * 提示：
 * 1 <= s.length <= 20
 * s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，或者点 '.' 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00065h {
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
