/**
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 * 示例 1:
 *
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,3,7,7,10,11,11]
 * 输出: 10
 * 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-element-in-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00540m {

    /**
     * 二分查找
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid - 1] != nums[mid] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            if (mid % 2 == 0) { // 偶数
                if (nums[mid] == nums[mid - 1]) { // 与左边相等
                    end = mid - 2;
                } else {
                    start = mid + 2;
                }
            } else {
                if (nums[mid] == nums[mid - 1]) { // 与左边相等
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return nums[start];
    }

    /**
     * 异或 O(n)
     * 没有用好有序数组这个条件
     * @param nums
     * @return
     */
    public int singleNonDuplicate1(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}
