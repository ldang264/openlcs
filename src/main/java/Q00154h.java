/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *  
 * ( 例如，数组[0,1,2,4,5,6,7] 可能变为[4,5,6,7,0,1,2])。
 *  
 * 请找出其中最小的元素。
 *  
 * 注意数组中可能存在重复的元素。
 *  
 * 示例 1：
 * 输入: [1,3,5]
 * 输出: 1
 *  
 * 示例2：
 * 输入: [2,2,2,0,1]
 * 输出: 0
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 *
 * 说明：
 * 这道题是寻找旋转排序数组中的最小值的延伸题目。
 * 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
 *  
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00154h {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = (left + right) >> 1; // 因为舍去小数的原因，mid会偏向left，所以right相等的情况要优先判断
            if (nums[right] == nums[mid]) {
                right--;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
