import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含 非负数 的数组和一个目标 整数k ，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，且总和为 k 的倍数，即总和为 n * k ，其中 n 也是一个整数。
 *
 * 示例 1：
 * 输入：[23,2,4,6,7], k = 6
 * 输出：True
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6。
 *
 * 示例 2：
 * 输入：[23,2,6,4,7], k = 6
 * 输出：True
 * 解释：[23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
 *
 *Example 3:
 * Input: nums = [23,2,6,4,7], k = 13
 * Output: false
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 0 <= sum(nums[i]) <= 231 - 1
 * 1 <= k <= 231 - 1
 *
 * 说明：
 * 数组的长度不会超过 10,000 。
 * 你可以认为所有数字总和在 32 位有符号整数范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00523m_Ans {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;

        // key：区间 [0..i] 里所有元素的和 % k
        // value：下标 i
        Map<Integer, Integer> map = new HashMap<>();
        // 理解初始化的意义
        map.put(0, -1);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (k != 0) {
                sum = sum % k; // 注：这一步太关键了
            }
            Integer oldI = map.get(sum);
            if (oldI == null) {
                map.put(sum, i);
            } else if (i - oldI > 1) {
                return true;
            }

        }
        return false;
    }

    public boolean checkSubarraySumTimeout(int[] nums, int k) {
        if (nums.length == 1) return false;
        nums[1] += nums[0];
        if (nums[1] % k == 0) return true;
        for (int i = 2; i < nums.length; i++) {
            nums[i] += nums[i - 1];
            if (nums[i] % k == 0) return true;
            for (int j = i - 1; j >= 0; j--) {
                if ((nums[i] - nums[j]) % k == 0) return true;
            }
        }
        return false;
    }
}
