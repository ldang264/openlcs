import java.util.ArrayList;
import java.util.Collections;
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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00046m {

    /**
     * 动态规划,应该会有很多重复计算
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>>[] dp = new List[nums.length];
        dp[0] = Collections.singletonList(Collections.singletonList(nums[0]));  // [[1]]
        for (int i = 1; i < nums.length; i++) {
            dp[i] = new ArrayList<>();
            for (List<Integer> list : dp[i - 1]) {
                int j = 0;
                while (j < list.size()) {
                    List<Integer> ansl = new ArrayList<>(list.subList(j, list.size()));
                    ansl.add(nums[i]);
                    ansl.addAll(list.subList(0, j));
                    dp[i].add(ansl);
                    j++;
                }
                List<Integer> ansl = new ArrayList<>();
                ansl.add(nums[i]);
                ansl.addAll(list);
                dp[i].add(ansl);
            }
        }
        return dp[nums.length - 1];
    }
}
