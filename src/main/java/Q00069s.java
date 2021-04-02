/**
 * 实现int sqrt(int x)函数。
 *
 * 计算并返回x的平方根，其中x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 * 输入: 4
 * 输出: 2
 *
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *     由于返回类型是整数，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00069s {

    /**
     * 二分搜索
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x <= 1) return x;
        int start = 1, end = x >> 1;
        while (true) {
            if (start == end) return start;
            int mid = (start + end) / 2;
            int i = x / mid;
            if (i == mid || x / (mid + 1) == mid) return mid;
            if (i > mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }

    public int mySqrt1(int x) {
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