/**
 * 给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 *
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 *
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[0]
 *
 * 示例 4：
 * 输入：nums = [1]
 * 输出：[1]
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 *
 * 进阶：
 * 你可以不使用代码库中的排序函数来解决这道题吗？
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00075m {

    /**
     * 单指针，两次扫描，处理0和1
     * @param nums
     */
    public void sortColors(int[] nums) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) { // 处理0
                if (i > p) { // 相等就不用换了
                    swap(nums, i, p);
                }
                p++;
            }
        }
        for (int i = p; i < nums.length; i++) {
            if (nums[i] == 1) { // 处理1
                if (i > p) {
                    swap(nums, i, p);
                }
                p++;
            }
        }
    }

    /**
     * 答案：双指针
     * @param nums
     */
    public void sortColorsAns(int[] nums) {
        int z = 0, t = nums.length - 1;
        for (int i = 0; i <= t; i++) {
            if (nums[i] == 0) {
                swap(nums, i, z); // 把0换到前面去
                z++;
            }
            if (nums[i] == 2) { // 如果这时候换到前面的是2
                swap(nums, i, t); // 把2换到最后
                t--;
                if (nums[i] != 1) { // 0或2则退回去，要再次处理
                    i--;
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
