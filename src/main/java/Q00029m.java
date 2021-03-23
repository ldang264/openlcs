/**
 * 给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数dividend除以除数divisor得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 * 示例1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 *
 * 示例2:
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 *
 * 提示：
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231− 1]。本题中，如果除法结果溢出，则返回 231− 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00029m {
    public int divide(int dividend, int divisor) {
        if (dividend == 0 || divisor == 1) return dividend;
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
            return -dividend;
        }
        return exec(dividend, divisor);
    }

    private int exec(long dividend, long divisor) {
        boolean symbol = true;
        if (dividend < 0) {
            dividend = -dividend;
            if (divisor < 0) {
                divisor = -divisor;
            } else {
                symbol = false;
            }
        } else if (divisor < 0) {
            symbol = false;
            divisor = -divisor;
        }
        int ans = 0;
        long last, i;
        // 100/3 = 100 - 3 = (1)97 - 6 =(3) 91 - 12 =(7) 79 - 24 ==(15) 55 - 48 ==(31) 7 == (32) 4 == (33) 1
        while (dividend >= divisor) {
            i = 1;
            last = divisor;
            while (dividend >= last) {
                dividend -= last;
                last <<= 1; // last翻倍
                ans += i;
                i <<= 1; // 2的倍数翻倍
            }
        }
        return symbol ? ans : -ans;
    }
}
