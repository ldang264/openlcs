/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：3
 *
 * 示例 2：
 * 输入：n = 11
 * 输出：0
 *
 * 限制：
 *
 * 0 <= n <2^31
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class J00044m {
    public int findNthDigit(int n) {
        if (n < 10) return n;
        int i = 2;
        long l = 0, s = 10;
        long start = 1;
        while (s <= Integer.MAX_VALUE) {
            l = s;
            start *= 10;
            s += start * i * 9;
            if (n >= l && n < s) break;
            i++;
        }
        int dis = (int) (n - l);
        int num = dis / i; // 多少个i位数
        int offset = dis % i;
        String target = "" + (start + num);
        return target.charAt(offset) - '0';
    }

    /**
     * 参考精讲
     * @param n
     * @return
     */
    public int findNthDigitAns(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit++;
            start *= 10;
            count = start * digit * 9;
        }
        int num = (n - 1) / digit;
        int offset = (n - 1) %  digit;
        return Long.toString(start + num).charAt(offset) - '0';
    }

}
