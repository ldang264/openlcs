/**
 * 给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 *
 * 示例2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1和num2的长度小于110。
 * num1 和num2 只包含数字0-9。
 * num1 和num2均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00043m {
    public String multiply(String num1, String num2) {
        if (num1.equals("0")) return num1;
        if (num2.equals("0")) return num2;
        if (num1.length() > num2.length()) {
            return exec(num1, num2);
        } else {
            return exec(num2, num1);
        }
    }

    private String exec(String s1, String s2) {
        int[] temp = new int[s1.length() + s2.length() + 1]; // 最大这么长
        int index = 0;
        for (int i = s1.length() - 1; i >= 0; i--) { // 123->321
            index = s1.length() - 1 - i; // 表示起点下标值
            int in = s1.charAt(i) - '0';
            int jw = 0; // 表示进位
            for (int j = s2.length() - 1; j >= 0; j--) { // 456->654
                int jn = s2.charAt(j) - '0';
                int v = in * jn + jw + temp[index]; // 当前这个位置的乘积+进位+前面算的值
                temp[index++] = v % 10; // 取模
                jw = v / 10; // 算出进位
            }
            if (jw > 0) {
                temp[index++] = jw;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = index - 1; i >= 0; i--) {
            sb.append(temp[i]);
        }
        return sb.toString();
    }
}
