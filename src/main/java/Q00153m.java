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

    /**
     * 为啥 high = pivot ，而 low = pivot + 1 呢？
     *
     * 我脑子里的二分查找的模板，还以为都是 right = middle - 1 或者 left = middle + 1 。。。。
     *
     * 求指点
     *
     * ========================================================================================
     *
     * 感谢各位大佬们解答！！！
     *
     * 本题的 left + 1 ，要么是更大的值（升序），要么突然降序，掉到了最小值。所以无论如何，最小值还是包括在寻找范围内的。而右侧区域，如果草率就 right - 1 的话，可能就会错过最小值了
     *
     * ========================================================================================
     *
     * 还有同学指出这么一个规律：
     *
     * 当 while (left < right) 时，对应的更新式是 left = middle + 1 ， right = middle
     *
     * 当 while (left <= right) 时，对应的更新式是 left = middle + 1，right = middle - 1
     *
     * 本题由于【当区间长度为1时，即可停止二分查找】，所以是 while (left < right) ，所以是 left = middle + 1，right = middle
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = (left + right) >> 1;
            if (nums[mid] < nums[right]) { // 可能mid就是最小值，所以不能right=mid-1
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
