/**
 * 给你一个整数数组 nums ，和一个整数 target 。
 * 该整数数组原本是按升序排列，但输入时在预先未知的某个点上进行了旋转。（例如，数组[0,1,2,4,5,6,7]可能变为[4,5,6,7,0,1,2] ）。
 * 请你在数组中搜索target ，如果数组中存在这个目标值，则返回它的索引，否则返回-1。
 *
 * 示例 1：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 *
 * 示例2：
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 *
 * 示例 3：
 * 输入：nums = [1], target = 0
 * 输出：-1
 *
 * 提示：
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * nums 肯定会在某个点上旋转
 * -10^4 <= target <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00033m {
    public int search(int[] nums, int target) {
        if (nums[0] == target) return 0;
        if (nums[nums.length - 1] == target) return nums.length - 1;
        if (nums[0] < target) { // 4512 找 5/6
            // 二分查找
            int start = 0;
            int end = nums.length - 1;
            while (true) {
                if (end - start <= 1) {
                    if (nums[start] == target) return start;
                    if (end - start == 1 && nums[end] == target) return end;
                    return -1;
                }
                int mid = (start + end) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] < nums[start]) {
                    end = mid - 1;
                } else {
                    if (nums[mid] > target) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            }
        } else { // 4512 找3/1/0
            if (nums[nums.length - 1] < target) { // 4512 找 3
                return -1;
            }
            // 4512 找1/0
            // 二分查找
            int start = 0;
            int end = nums.length - 1;
            while (true) {
                if (end - start <= 1) {
                    if (nums[start] == target) return start;
                    if (end - start == 1 && nums[end] == target) return end;
                    return -1;
                }
                int mid = (start + end) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] > nums[end]) {
                    start = mid + 1;
                } else {
                    if (nums[mid] > target) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            }
        }
    }
}
