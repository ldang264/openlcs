/**
 *实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00050m_QuickMul {
    public static void main(String[] args) {
        Q00050m_QuickMul mp = new Q00050m_QuickMul();
        double x1 = 2.00000, x2 = 2.10000, x3 = 2.00000, x4 = 0.00001,    x5 = 1.00000;
        int    n1 = 10     , n2 = 3      , n3 = -2,      n4 = 2147483647, n5 = -2147483648;
        /*System.out.println(mp.myPow(x1, n1));
        System.out.println(mp.myPow(x2, n2));
        System.out.println(mp.myPow(x3, n3));
        System.out.println(mp.myPow(x4, n4));*/
        System.out.println(mp.myPow(x5, n5));
    }
    /**
     * 快速幂运算
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (x == 0 || n == 0) return 1;
        if (n < 0) {
            return 1 / quickMul(x, -(long) n);
        }
        return quickMul(x, n);
    }

    /**
     * 快速幂运算
     * @param x
     * @param n
     * @return
     */
    public double quickMul(double x, long n) {
        if (n == 1) return x;
        long N = n/2;
        double X = quickMul(x, N);
        return n % 2 == 1 ? X * X * x : X * X;
    }
}
