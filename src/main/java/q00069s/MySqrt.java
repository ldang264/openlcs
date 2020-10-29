package q00069s;

/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MySqrt {

    public int mySqrt(int x) {
        if (x <= 1) return x;
        int start = 1, end = x / 2 + 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            long mid2 = (long) mid * mid;
            long mid_1_2 = (long) (mid + 1) * (mid + 1);
            if (mid_1_2 == x) return mid + 1;
            if (x >= mid2 && x < mid_1_2) return mid;
            if (mid_1_2 < x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return 0;
    }
}
        /*long s2 = start * start;
        if (s2 == (long) x) {
            return start;
        }
        long e2 = end * end;
        if (e2 == x) {
            return end;
        }
        if (s2 < x) {

        }
        for (int i = x / 2 + 1; i >= 1; i--) {
            long i2 = i * i;
            int i1 = i - 1;
            long i12 = i1 * i1;
            if (i2 == x) return i;
            if (i12 == x || (i2 > x && i12 < x)) return i1;
        }*/
