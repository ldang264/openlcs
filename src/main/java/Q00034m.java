/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
 *
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 * 示例2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 *
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * 
 *
 * 提示：
 * 0 <= nums.length <= 105
 * -109<= nums[i]<= 109
 * nums是一个非递减数组
 * -109<= target<= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00034m {
    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int start = 0, end = nums.length - 1, mid = -1;
        while (start <= end) {
            mid = (start + end) >> 1;
            if (nums[mid] == target) break;
            if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        if (start > end) return new int[]{-1, -1};
        start = mid; end = mid;
        int[] ans = new int[2];
        while (nums[start] == target && start-- > 0); // 找左边界
        ans[0] = start + 1;
        while (nums[end] == target && end++ < nums.length - 1); // 找右边界
        ans[1] = end - 1;
        return ans;
    }
}
