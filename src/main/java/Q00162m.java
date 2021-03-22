/**
 * 峰值元素是指其值大于左右相邻值的元素。
 * 给你一个输入数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设nums[-1] = nums[n] = -∞ 。
 *
 * 示例 1：
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 *
 * 示例2：
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5 
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 *     或者返回索引 5， 其峰值元素为 6。
 *
 * 提示：
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 * 
 *
 * 进阶：你可以实现时间复杂度为 O(logN) 的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-peak-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00162m {

    /**
     * 二分法+迭代
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1, mid;
        while (true) {
            if (start == end) return start; //
            mid = (start + end) / 2;
            if (nums[mid] < nums[mid + 1]) { // 递增
                start = mid + 1; // 向右找
            } else {
                end = mid; // 向左找
            }
        }
    }

    private int ans;

    /**
     * 比较傻的方法
     * @param nums
     * @return
     */
    public int findPeakElement1(int[] nums) {
        if (nums.length == 1) return 0; // 一个数直接返回
        if (nums[0] > nums[1]) return 0; // 第一个是峰值
        if (nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1; // 最后一个是峰值
        find(nums, 1, nums.length - 2); // 在第一个与最后一个之间找峰值
        return ans;
    }

    private boolean find(int[] nums, int start, int end) {
        if (start > end) return false; // 跳出寻找
        int mid = (start + end) / 2;
        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) { // 找到峰值
            ans = mid;
            return true;
        }
        return find(nums, start, mid - 1) || find(nums, mid + 1, end); // 先左后右
    }
}