/**
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
 *
 * Example 1:
 * Input: num1 = "11", num2 = "123"
 * Output: "134"
 *
 * Example 2:
 * Input: num1 = "456", num2 = "77"
 * Output: "533"
 *
 * Example 3:
 * Input: num1 = "0", num2 = "0"
 * Output: "0"
 *
 * Constraints:
 * 1 <= num1.length, num2.length <= 104
 * num1 and num2 consist of only digits.
 * num1 and num2 don't have any leading zeros except for the zero itself.
 *  
 *
 * Follow up: Could you solve it without using any built-in BigInteger library or converting the inputs to integer directly?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00415s {
    public String addStrings(String num1, String num2) {
        char[] cs = new char[Math.max(num1.length(), num2.length()) + 1];
        int idx = cs.length - 1, jw = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 && j >= 0) {
            int v = (num1.charAt(i--) - '0') + (num2.charAt(j--) - '0') + jw;
            if (v >= 10) {
                jw = 1;
                v -= 10;
            } else {
                jw = 0;
            }
            cs[idx--] = (char) (v + '0');
        }
        while (i >= 0) {
            int v = (num1.charAt(i--) - '0') + jw;
            if (v >= 10) {
                jw = 1;
                v -= 10;
            } else {
                jw = 0;
            }
            cs[idx--] = (char) (v + '0');
        }
        while (j >= 0) {
            int v = (num2.charAt(j--) - '0') + jw;
            if (v >= 10) {
                jw = 1;
                v -= 10;
            } else {
                jw = 0;
            }
            cs[idx--] = (char) (v + '0');
        }
        if (jw == 1) {
            cs[0] = '1';
            return new String(cs);
        }
        return new String(cs, 1, cs.length - 1);
    }
}
