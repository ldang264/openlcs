/**
 *给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 示例2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00035s {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums[0] >= target) {
            return 0;
        }
        return find(nums, target, 0, nums.length - 1);
    }

    private int find(int[] nums, int target, int start, int end) {
        int mid = (start + end) / 2;
        if (nums[mid] == target) return mid; // 匹配
        if (nums[mid] > target) { // 左边找
            if (mid == 0) return 0; // 越左界
            if (nums[mid - 1] < target) return mid;
            return find(nums, target, start, mid - 1);
        } else { // 右边找
            if (mid == nums.length - 1) return nums.length; // 越右界
            if (nums[mid + 1] > target) return mid + 1;
            return find(nums, target, mid + 1, end);
        }
    }
}
