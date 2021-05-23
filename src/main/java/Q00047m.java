import java.util.*;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 提示：
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00047m {

    private List<List<Integer>> ans;

    private boolean[] visited;

    private int[] temp;

    private int idx;

    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        visited = new boolean[nums.length];
        temp = new int[nums.length];
        Arrays.sort(nums);
        int prev = -11;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != prev) {
                prev = nums[i];
                backtrace(nums, i);
            }
        }
        return ans;
    }

    private void backtrace(int[] nums, int i) {
        visited[i] = true;
        temp[idx++] = nums[i];
        if (idx == nums.length) {
            List<Integer> vals = new ArrayList<>(idx);
            for (int val : temp) {
                vals.add(val);
            }
            ans.add(vals);
        } else {
            for (int j = 0; j < nums.length; j++) {
                if (!visited[j] && (j == 0 || visited[j - 1] || nums[j - 1] < nums[j])) { // 没有加入过j并且(j-1加入过且前后不相等)
                    backtrace(nums, j);
                }
            }
        }
        idx--;
        visited[i] = false;
    }
}
