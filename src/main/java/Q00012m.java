/**
 * 罗马数字包含以下七种字符：I，V，X，L，C，D和M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 *
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1到 3999 的范围内。
 *
 * 示例1:
 *
 * 输入:3
 * 输出: "III"
 * 示例2:
 *
 * 输入:4
 * 输出: "IV"
 * 示例3:
 *
 * 输入:9
 * 输出: "IX"
 * 示例4:
 *
 * 输入:58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例5:
 *
 * 输入:1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00012m {
    public String intToRoman(int num) {
        if (num >= 1000) { // 1000-3999
            int a = num / 1000;
            int b = num % 1000;
            return join("", "M", a) + intToRoman(b);
        } else if (num >= 100) { // 100 - 999
            int a = num / 100;
            int b = num % 100;
            return handle(a, "C", "D", "M") + intToRoman(b);
        } else if (num >= 10) { // 10-99
            int a = num / 10;
            int b = num % 10;
            return handle(a, "X", "L", "C") + intToRoman(b);
        } else {
            return handle(num, "I", "V", "X");
        }
    }

    private String handle(int num, String i, String v, String x) {
        if (num == 9){
            return join(i, x);
        } else if (num >= 5) {
            return join(v, i, num - 5);
        } else if (num == 4) {
            return join(i, v);
        } else {
            return join("", i, num);
        }
    }

    private String join(String prefix, String suffix) {
        return prefix + suffix;
    }

    private String join(String prefix, String suffix, int sn) {
        StringBuilder sb = new StringBuilder(prefix);
        for (int i = 0; i < sn; i++) {
            sb.append(suffix);
        }
        prefix = sb.toString();
        return prefix;
    }

     /* if (num == 9){ // 1-9
                return join("I", "X");
            } else if (num >= 5) {
                return join("V", "I", num - 5);
            } else if (num == 4) {
                return join("I", "V");
            } else {
                return join("", "I", num);
            }*/

    /*
    private String intToRoman(String s) {
        if (s.length() == 4) {

        } else if (s.length() == 3) {

        } else if (s.length() == 2) {
            if (s.charAt(0) == '1') {
                return 'V' + intToRoman(s.substring(1));
            }
        } else if (s.length() == 1) {
            if (s.equals("1")) {
                return "I";
            } else if (s.equals("2")) {
                return "II";
            } else if (s.equals("3")) {
                return "III";
            } else if (s.equals("4")) {
                return "IV";
            } else if (s.equals("5")) {
                return "V";
            } else if (s.equals("6")) {
                return "VI";
            } else if (s.equals("7")) {
                return "VII";
            } else if (s.equals("8")) {
                return "VIII";
            } else if (s.equals("9")) {
                return "IX";
            }
        }
    }*/
}
