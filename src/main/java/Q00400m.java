/**
 * 在无限的整数序列1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第n 位数字。
 *
 * 注意：n是正数且在 32 位整数范围内（n < 231）。
 *
 * 示例 1：
 * 输入：3
 * 输出：3
 *
 * 示例 2：    `
 * 输入：11
 * 输出：0
 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 *
 * Constraints:
 * 1 <= n <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nth-digit
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00400m {
    // 1 1 = 1
    // 2 1 + 1 * 9 = 1 + 9 * 1 * 10 ^ 0
    // 3 9 + 2 * 90 = 10 + 9 * 2 * 10^ 1
    // 4 189 + 3 * 900 = 190 + 9 * 3 * 10^2
    // n = 56  prev = 9  len = 2 ten = 10
    public int findNthDigit(int n) {
        int l = 0, p, len = 1, ten = 1;
        while ((p = 9 * len * ten) > l && p < n) { // 一直减掉差比数列的当前项
            n -= p;
            l = p;
            ten *= 10;
            len++;
        }
        n--;
        int num = n / len + ten; // 第n位对应的整数
        int offset = n % len; // 在整数中的偏移位置
        return Integer.toString(num).charAt(offset) - '0';
    }

    public int findNthDigit1(int n) {
        int prev = 1, next = 1, len = 1, ten = 1;
        while (true) {
            prev = next; // 计算其实值
            next += 9 * len * ten;
            if (next > n || next <= prev) break; // 超出n或者越界
            ten *= 10;
            len++;
        }
        n -= prev;
        int num = n / len + ten; // 第n位对应的整数
        int offset = n % len; // 在整数中的偏移位置
        return Integer.toString(num).charAt(offset) - '0';
    }
}
