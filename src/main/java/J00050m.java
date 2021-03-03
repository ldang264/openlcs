/**
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 *
 * 示例2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 *
 * 示例3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 * 说明:
 * -100.0 <x< 100.0
 * n是 32 位有符号整数，其数值范围是[−231,231− 1] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class J00050m {
    public double myPow(double x, int n) {
        if (x == 0) return 0; // 0的任何次幂都是0
        if (n == 0) return 1; // 非0的任何0次幂都是1
        if (n == 1) return x; // 非0的任何1次幂是其本身
        if (n == -1) return 1 / x; // 非0的任何-1次幂是其倒数
        double val = myPow(x, n / 2); // 其他数值直接递归
        return val * val * ((n & 1) == 1 ? (n < 0 ? 1 / x : x) : 1.0);
    }
}
