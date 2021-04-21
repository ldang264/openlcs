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

    private List<Integer> temp;

    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        visited = new boolean[nums.length];
        temp = new ArrayList<>(nums.length);
        Arrays.sort(nums);
        int prev = nums[0];
        backtrace(nums, 0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prev) {
                prev = nums[i];
                backtrace(nums, i);
            }
        }
        return ans;
    }

    private void backtrace(int[] nums, int i) {
        visited[i] = true;
        temp.add(nums[i]);
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
        } else {
            if (!visited[0]) backtrace(nums, 0);
            for (int j = 1; j < nums.length; j++) {
                if (!visited[j] && (visited[j - 1] || nums[j - 1] < nums[j])) { // 没有加入过j并且(j-1加入过且前后不相等)
                    backtrace(nums, j);
                }
            }
        }
        temp.remove(temp.size() - 1);
        visited[i] = false;
    }
}
