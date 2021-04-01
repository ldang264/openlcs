/**
 * 给你一个整数数组nums，请你将该数组升序排列。
 *
 * 示例 1：
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *
 * 提示：
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00912m {

    /**
     * 快速排序
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int left, int right) {
        if (left >= right) return;
        int l = left, r = right, pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) { // 从右向左找到第一个比基准值小的
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) { // 从左向右找到第一个比基准值大的
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        sort(nums, l, left - 1);
        sort(nums, left + 1, r);
    }
}
