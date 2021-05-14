import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是 2 。
 * 示例：
 * 输入：[4, 6, 7, 7]
 * 输出：[[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 *
 * 提示：
 *  1 <= nums.length <= 15
 * -100 <= nums[i] <= 100
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00491m {

    private List<List<Integer>> ans;

    private List<Integer> temp;

    /**
     * 答案
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        ans = new ArrayList<>();
        temp = new ArrayList<>();
        backtrace(nums, 0, -101);
        return ans;
    }

    /**
     * 回溯
     * @param nums
     */
    private void backtrace(int[] nums, int i, int last) {
        if (i == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if (nums[i] >= last) { // 加入数据的条件
            temp.add(nums[i]);
            backtrace(nums, i + 1, nums[i]);
            temp.remove(temp.size() - 1);
        }
        if (nums[i] != last) { // 去重的条件
            backtrace(nums, i + 1, last); // 直接处理下一个，跳过当前下标
        }
    }
}
