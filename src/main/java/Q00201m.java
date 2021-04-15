/**
 * 给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 *
 * 示例 1：
 * 输入：left = 5, right = 7
 * 输出：4
 *
 * 示例 2：
 * 输入：left = 0, right = 0
 * 输出：0
 *
 * 示例 3：
 * 输入：left = 1, right = 2147483647
 * 输出：0
 *
 * 提示：
 * 0 <= left <= right <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bitwise-and-of-prevbers-range
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00201m {

    /**
     * 比较low
     * @param left
     * @param right
     * @return
     */
    public int rangeBitwiseAnd(int left, int right) {
        // n & (n - 1)将去掉n最低位的1
        if (left == 0 || left == right) return left; // 直接返回0
        if (right == left + 1) return left & right;
        int prev = 1, next;
        while (prev <= right) {
            next = prev << 1;
            if (prev == left) { // 如果left是2的次幂，如果right < 2 * left，返回left，否则返回0
                return right < next ? left : 0;
            } else if (prev == right) { // 如果right是2的次幂，left=right返回left，否则返回0
                return 0;
            } else if (prev > left && prev < right) { // 如果left和right之间有2的次幂，返回0
                return 0;
            } else if (left > prev && right < next) { // 如果left和right之间无2的次幂，返回比left小的那个2的次幂
                for (int i = right; i >= left; i--) {
                    right &= i;
                }
                return right;
            }
            prev = next; // 翻倍
        }
        return 0;
    }

    /**
     * 答案，依次抹去低位，直到相等
     * @param left
     * @param right
     * @return
     */
    public int rangeBitwiseAndAns1(int left, int right) {
        int count = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            count++;
        }
        return left << count;
    }

    /**
     * 答案，抹去right的低位1
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAndAns2(int m, int n) {
        while (m < n) {
            // 抹去最右边的 1
            n = n & (n - 1);
        }
        return n;
    }
}
