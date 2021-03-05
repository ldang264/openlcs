/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
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
 *
 * 0 <= nums.length <= 300
 * -231 <= nums[i] <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00041h {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        int min = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] < min) {
                min = nums[i]; // 找到最小值
            }
        }
        if (min != 1) return 1;
        for (int i = 0; i < nums.length; i++) {
            int v ;
            // 置换位置[3, 4, -1, 1] -> [1, -1, 3, 4]
            while ((v = nums[i] - min) >= 0 && v < nums.length && v != (nums[v] - min)) {
                int temp = nums[i];
                nums[i] = nums[v];
                nums[v] = temp;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != i + min) {
                return i + min; // 如果当前数字不在位置上，则当前数字就是缺失的那个数
            }
        }
        return nums.length + 1;
    }
}
