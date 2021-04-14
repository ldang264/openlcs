/**
 * 下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。
 *
 * 示例1:
 *  输入：num = 2（或者0b10）
 *  输出：[4, 1] 或者（[0b100, 0b1]）
 *
 * 示例2:
 *  输入：num = 1
 *  输出：[2, -1]
 *
 * 提示:
 * num的范围在[1, 2147483647]之间；
 * 如果找不到前一个或者后一个满足条件的正数，那么输出 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/closed-number-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00005_04m {
    public int[] findClosedNumbers(int num) {
        int[] ans = new int[2];
        // 略大：从低位向高位找，第一个01组合交换位置，且低位的1都向右移动
        // 略小：从低位向高位找，第一个10组合交换位置，且低位的1都向左移动
        int bit = 0, low = 1; // 2的0到30次幂
        while (bit <= 30) {
            int high = low << 1; // 2的1到31次幂
            if (ans[0] == 0 && (num & low) != 0 && (num & high) == 0) { // 低位是1，高位是0
                ans[0] = num + low; // 先得到01交换的值
                int t = num & (low - 1); // 得到低位往后的值
                if (t > 0) {
                    ans[0] -= t; // 减掉这个要处理的值
                    while ((t & 1) == 0) { // 偶数就一直除以2
                        t >>= 1;
                    }
                    ans[0] += t; // 1全部靠右了
                }
                if (ans[1] > 0) break;
            }
            if (ans[1] == 0 && (num & low) == 0 && (num & high) != 0) { // 低位是0，高位是1
                ans[1] = num - low; // 先得到10交换的值
                int t = num & (low - 1); // 得到低位往后的值
                if (t > 0) {
                    ans[1] -= t; // 减掉这个要处理的值
                    while (t < low) { // 一直乘以2，直到超过low
                        t <<= 1;
                    }
                    ans[1] += t >> 1; // 加上除以2的值
                }
                if (ans[0] > 0) break;
            }
            bit++;
            low = high;
        }
        if (ans[0] <= 0) ans[0] = -1; // 01交换就是负数了
        if (ans[1] <= 0) ans[1] = -1; // 无10组合
        return ans;
    }
}
