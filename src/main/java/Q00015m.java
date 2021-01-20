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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00015m {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length < 3) return lists;
        Arrays.sort(nums); // 排序[-4, -1, -1, 0, 1, 2]
        int left, right;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 如果i和i-1相同，需要去重，则跳过
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[left], nums[right])); // 相等则加入
                    for (int k = left + 1; k < right; k++) { // left右移到下一个不等的
                        if (nums[k] != nums[left]) {
                            break;
                        }
                        left++;
                    }
                    left++;
                    for (int k = right - 1; k > left; k--) { // right左移到下一个不等的
                        if (nums[k] != nums[right]) {
                            break;
                        }
                        right--;
                    }
                    right--;
                } else if (sum > 0){ // 仅right左移
                    right--;
                } else { // 仅left右移
                    left++;
                }
            }
        }
        return lists;
    }
}
