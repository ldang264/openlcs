/**
 * 给你一个整数数组 nums，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释:子数组 [2,3] 有最大乘积 6。
 *
 * 示例 2:
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释:结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00152m {
    private int ans;

    public int maxProduct(int[] nums) {
        ans = 0;
        if (nums.length == 1) return nums[0];
        int allTemp = 1, temp = 1;
        int start = -1, end = - 1;
        for (int i = 0; i < nums.length; i++) {
            allTemp *= nums[i];
            if (nums[i] != 0) {
                temp *= nums[i];
                if (start == -1) {
                    start = i; // 找到起始位置
                }
                end = i; // 不断更新结束位置
            } else if (start != -1) { // 中间有0才会计算
                if (temp > 0) { // 在这一段是正数，不需要收缩了
                    ans = Math.max(ans, temp);
                } else if (start < end) { // 一定小于0
                    maxSub(nums, temp, start, end);
                }
                temp = 1;
                start = end = -1;

            }
        }
        if (allTemp > 0) { // 全部积为正数，立即返回
            return allTemp;
        }
        if (allTemp < 0) { // 整个数组不含0，且积为负数
            maxSub(nums, allTemp, start, end);
        } else if (end != -1){ // 最后可能还有1及以上个数字能够算出最值
            if (temp > 0) { // 在这一段是正数，不需要收缩了
                ans = Math.max(ans, temp);
            } else  if (start < end) { // 一定小于0
                maxSub(nums, temp, start, end);
            }
        }
        return ans;
    }

    private void maxSub(int[] nums, int temp, int start, int end) {
        int sub = temp, i = start;
        while (i < end && nums[i] > 0) {
            sub /= nums[i];
            i++;
        }
        ans = Math.max(ans, sub / nums[i]); // 从左向右，一直除到第一个负数
        sub = temp; i = end;
        while (i > start && nums[i] > 0) {
            sub /= nums[i];
            i--;
        }
        ans = Math.max(ans, sub / nums[i]); // 从右向左，一直除到第一个负数
    }
}
