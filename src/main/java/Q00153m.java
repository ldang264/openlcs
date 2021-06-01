/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组[0,1,2,4,5,6,7] 可能变为[4,5,6,7,0,1,2] 。
 * 请找出其中最小的元素。
 *
 * 示例 1：
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 *
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出：1
 *
 * 提示：
 * 1 <= nums.length <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 中的所有整数都是 唯一 的
 * nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00153m {

    public int findMin(int[] nums) {
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) return nums[0]; // 处理唯一元素和升序的情况
        int start = 0, end = nums.length - 1; // 左右指针
        int mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (mid == 0) return nums[1]; // 形如3,1,2这样
            if (mid == nums.length - 1) return nums[mid]; // 形如2,3,1这样
            if (nums[mid - 1] > nums[mid] && nums[mid] < nums[mid + 1]) return nums[mid]; // 形如3,1,2这样
            if (nums[mid] > nums[0]) { // 在左边半边
                start = mid + 1;
            } else { // 在右半边
                end = mid - 1;
            }
        }
        return nums[end];
    }
}
