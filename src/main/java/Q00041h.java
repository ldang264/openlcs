/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
 *
 * 示例 1：
 * 输入：nums = [1,2,0]
 * 输出：3
 *
 * 示例 2：
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 *
 * 示例 3：
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 *
 * 提示：
 * 0 <= nums.length <= 300
 * -231 <= nums[i] <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00041h {

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int t;
            while (nums[i] > 0 && nums[i] <= nums.length && nums[t = nums[i] - 1] != nums[i]) { // 置换
                int bak = nums[t];
                nums[t] = nums[i];
                nums[i] = bak;
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] != i) return i;
        }
        return nums.length + 1;
    }
}
