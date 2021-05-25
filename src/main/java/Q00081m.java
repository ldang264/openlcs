/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组[0,0,1,2,2,5,6]可能变为[2,5,6,0,0,1,2])。
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回true，否则返回false。
 *
 * 示例1:
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 *
 * 示例2:
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 *
 * 进阶:
 * 这是 搜索旋转排序数组的延伸题目，本题中的nums 可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 *
 作者：reedfan
 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/solution/zai-javazhong-ji-bai-liao-100de-yong-hu-by-reedfan/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Q00081m {

    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid;
        while (start <= end) {
            if (nums[start] == target || nums[end] == target || nums[mid = (start + end) >> 1] == target) return true; // 相等直接返回true
            if (nums[mid] == nums[start]) { // 左边非递增
                start++;
                continue;
            }
            if (nums[mid] == nums[end]) { // 右边非递增
                end--;
                continue;
            }
            if (nums[mid] > nums[start]) {
                if (nums[mid] > target && nums[start] < target) { // 左侧递增，且在左侧
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] < target && target < nums[end]) { // 右侧递增，且在右侧
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }









    /*public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) return true;
            if (nums[start] == nums[end]) { // 这种是相等的特殊情况
                start++;
                continue;
            }
            if (nums[start] <= nums[mid]) { // 在有序的左半边
                if (nums[start] <= target && target < nums[mid]) { // 在左半边
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else { // 在有序的右半边
                if (target <= nums[end] && target > nums[mid]) { // 在右半边
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }*/
}
