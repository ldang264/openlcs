/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组[0,1,2,4,5,6,7] 可能变为[4,5,6,7,0,1,2])。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 注意数组中可能存在重复的元素。
 * <p>
 * 示例 1：
 * 输入: [1,3,5]
 * 输出: 1
 * <p>
 * 示例2：
 * 输入: [2,2,2,0,1]
 * 输出: 0
 * 说明：
 * <p>
 * 这道题是寻找旋转排序数组中的最小值的延伸题目。
 * 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
// 二分查找
public class Q00154h {

    /**
     * 参考了答案
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1, mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                end--;
            }
        }
        return nums[end];
    }

    public int findMin1(int[] nums) {
        if (nums == null) return -1;
        if (nums.length == 1) return nums[0];
        int start = 0, end = nums.length - 1; // 左右指针
        while (start < end) { // 去掉开头相等的
            if (nums[start] != nums[start + 1]) {
                break;
            }
            start++;
        }
        while (start < end) { // 去掉结尾相等的
            if (nums[end] != nums[end - 1]) {
                break;
            }
            end--;
        }
        if (start == end) return nums[start]; // 全部相等
        if (nums[start] == nums[end]) start++; // 让开头比结尾元素不相等
        if (nums[end] > nums[start]) return nums[start]; // 说明递增
        int mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (mid == start) return Math.min(nums[mid], nums[mid + 1]); // 与最左边相等，返回较小的
            if ((nums[mid] < nums[mid - 1] && nums[mid] <= nums[mid + 1])) return nums[mid]; // 找到目标值
            if (nums[mid] > nums[0]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return nums[end];
    }

}
