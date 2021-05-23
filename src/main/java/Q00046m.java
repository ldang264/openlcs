import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 提示：
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00046m {

    private List<List<Integer>> ans;

    private int[] temp;

    private int idx;

    private boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        temp = new int[nums.length];
        visited = new boolean[nums.length];
        idx = 0;
        for (int i = 0; i < nums.length; i++) {
            backtrace(nums, i); // 以每一个下标i为起点回溯
        }
        return ans;
    }

    private void backtrace(int[] nums, int i) {
        temp[idx++] = nums[i];
        visited[i] = true;
        if (idx == nums.length) {
            List<Integer> vals = new ArrayList<>(idx);
            for (int val : temp) {
                vals.add(val);
            }
            ans.add(vals);
        } else {
            for (int j = 0; j < nums.length; j++) {
                if (!visited[j]) {
                    backtrace(nums, j);
                }
            }
        }
        idx--;
        visited[i] = false;
    }
}
