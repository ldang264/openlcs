

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00215m {
    public int findKthLargest(int[] nums, int k) {
        return find(nums, k, 0, nums.length - 1);
    }

    /**
     * 快速选择
     * @param nums
     * @param k
     * @param left
     * @param right
     */
    private int find(int[] nums, int k, int left, int right) {
        if (left >= right) return nums[left];
        int l = left, r = right, pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] <= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] >= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        int pos = left - k + 1;
        if (pos == 0) {
            return nums[left];
        } else {
            return pos < 0 ? find(nums, k, left + 1, r) : find(nums, k, l, left - 1);
        }
    }
}
