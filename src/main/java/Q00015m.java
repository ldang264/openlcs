import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 提示：
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00015m {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length <= 2) return ans;
        Arrays.sort(nums);
        int sum, left, right;
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
            left = i + 1; right = nums.length - 1;
            while (left < right) {
                sum = nums[left] + nums[right];
                if (sum == -nums[i]) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left - 1] == nums[left]) left++; // 跳到left不重复的位置
                    while (right > left && nums[right + 1] == nums[right]) right--; // 跳到right不重复的位置
                } else if (sum > -nums[i]) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }
}
