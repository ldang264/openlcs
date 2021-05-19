import java.util.Arrays;

/**
 * 给定一个包括n 个整数的数组nums和 一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 示例：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * 提示：
 * 3 <= nums.length <= 10^3
 * -10^3<= nums[i]<= 10^3
 * -10^4<= target<= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00016m {
    public int threeSumClosest(int[] nums, int target) {
        int ans = 3_000, left, right, sum;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            left = i + 1; right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum == target) return target;
                if (sum > target) right--;
                else left++;
                if (Math.abs(sum - target) < Math.abs(ans - target)) { // 比较距离
                    ans = sum;
                }
            }
        }
        return ans;
    }
}
