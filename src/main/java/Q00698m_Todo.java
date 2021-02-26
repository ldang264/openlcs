import java.util.Arrays;

/**
 * 给定一个整数数组nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 *
 * 示例 1：
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 *
 * 提示：
 *
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00698m_Todo {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length == 1 || k == 1) return true;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        sum /= k;
        Arrays.sort(nums);
        int end = nums.length - 1;
        if (nums[end] > sum) return false;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < sum) break;
            if (nums[i] > sum) return false;
            end--;
            k--;
        }

        return false;
    }

}
