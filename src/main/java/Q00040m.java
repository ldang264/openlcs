import java.util.*;

/**
 * 给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 *
 * 示例1:
 * 输入: candidates =[10,1,2,7,6,1,5], target =8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * 示例2:
 * 输入: candidates =[2,5,2,1,2], target =5,
 * 所求解集为:
 * [
 *  [1,2,2],
 *  [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00040m {

    private List<List<Integer>> ans;

    private List<Integer> temp;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        temp = new ArrayList<>();
        Arrays.sort(candidates); // 排序，方便判断前后相等
        backtrace(candidates, 0, target, true);
        return ans;
    }

    private void backtrace(int[] candidates, int i, int target, boolean prev) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (i == candidates.length) return;
        backtrace(candidates, i + 1, target, false); // 直接找下一个
        if ((prev || candidates[i] > candidates[i - 1]) && (target -= candidates[i]) >= 0) {
            temp.add(candidates[i]);
            backtrace(candidates, i + 1, target, true); // 当前下标可一直选
            temp.remove(temp.size() - 1);
        }
    }
}
