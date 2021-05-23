import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括target）都是正整数。
 * 解集不能包含重复的组合。
 *
 * 示例1：
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * 示例2：
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *  [2,2,2,2],
 *  [2,3,3],
 *  [3,5]
 * ]
 *
 * 提示：
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00039m {

    private List<List<Integer>> ans;

    private List<Integer> temp;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        temp = new ArrayList<>();
        backtrace(candidates, 0, target);
        return ans;
    }

    private void backtrace(int[] candidates, int i, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (i == candidates.length) return;
        backtrace(candidates, i + 1, target); // 直接找下一个
        target -= candidates[i];
        if (target >= 0) { // 负数就停止
            temp.add(candidates[i]);
            backtrace(candidates, i, target); // 当前下标可一直选
            temp.remove(temp.size() - 1);
        }
    }
}
