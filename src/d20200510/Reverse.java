package d20200510;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
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
