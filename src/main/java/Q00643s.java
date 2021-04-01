/**
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 * 示例：
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *
 * 提示：
 *
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-average-subarray-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00643s {
    public double findMaxAverage(int[] nums, int k) {
        int index = 0, sum = 0;
        while (index < k) { // 先算到k
            sum += nums[index];
            index++;
        }
        int max = sum;
        while (index < nums.length) {
            sum += nums[index] - nums[index - k]; // 滑动窗口
            index++;
            max = Math.max(max, sum);
        }
        return max * 1.0d / k;
    }
}
