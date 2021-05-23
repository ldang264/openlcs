/**
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 *
 * 示例 2：
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 *
 * 示例 3：
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 *
 * 示例 4：
 * 输入：nums = [1]
 * 输出：[1]
 *
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00031m {

    // 1 3 5 4 2 start = 2
    // 1 3 5 2 4
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) return;
        int start = nums.length - 1;
        while (start > 0 && nums[start - 1] >= nums[start]) { // 从右向左，找到前一个小于后一个的，即132里的3
            start--;
        }
        // 此时start在右向左数的最高点
        if (start > 0) { // 可能整个数组就是降序排列的，则直接反转
            int j = start + 1;
            while (j < nums.length && nums[j] > nums[start - 1]) { // 找到右侧比i - 1这个位置大的数，即132里的2
                j++;
            }
            swap(nums, start - 1, j - 1); // 交换1和2，数组变为231
        }
        // 反转i到结尾，变为213
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
