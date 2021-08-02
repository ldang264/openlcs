/**
 * 给定一个长度为 n 的整数数组A。
 *
 * 假设Bk是数组A顺时针旋转 k 个位置后的数组，我们定义A的“旋转函数”F为：
 *
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]。
 *
 * 计算F(0), F(1), ..., F(n-1)中的最大值。
 *
 * 注意:
 * 可以认为 n 的值小于 105。
 *
 * 示例:
 *
 * A = [4, 3, 2, 6]
 *
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 *
 * 所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-function
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00396m {
    public int maxRotateFunction(int[] nums) {
        int sum = 0, f = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; // 所有元素之和
            f += i * nums[i]; // 计算F0=0到n-1
        }
        int ans = f;
        for (int i = nums.length - 1; i >= 1; i--) {
            f = f + sum - nums.length * nums[i]; // Fk - Fk-1 = sum - n * nums[i]
            ans = Math.max(ans, f);
        }
        return ans;
    }
}
