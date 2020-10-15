package q00007;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Reverse {

    public static void main(String[] args) {
        Reverse main = new Reverse();
        System.out.println(main.reverse(123));
        System.out.println(main.reverse(-123));
        System.out.println(main.reverse(120));
        System.out.println(main.reverse(-2147483648));
    }

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        String sy = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        boolean startWithZero = sy.charAt(sy.length() - 1) == '0';
        boolean isNegative = sy.charAt(0) == '-';
        for (int i = sy.length() - 1; i >= (isNegative ? 1 : 0); i--) {
            char c = sy.charAt(i);
            if (!startWithZero) {
                sb.append(c);
            } else {
                if (c != '0') {
                    sb.append(c);
                    startWithZero = false;
                }
            }
        }
        String rev = sb.toString();
        long revL = Long.parseLong(isNegative ? '-' + rev : rev);
        if (revL < Integer.MIN_VALUE || revL > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) revL;
    }
}