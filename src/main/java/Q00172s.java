/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00172s {
    private int fn;

    public int trailingZeroes(int n) {
        if (n < 5) return 0;
        fn = 0;
        findFive(1, n);
        return fn;
    }

    /**
     * 二分，比较垃圾
     * @param start
     * @param end
     */
    private void findFive(int start, int end) {
        if (start == end) {
            while ((start % 5) == 0) {
                fn++;
                start /= 5;
            }
        } else {
            int mid = (start + end) / 2;
            findFive(start, mid);
            findFive(mid + 1, end);
        }
    }
}
