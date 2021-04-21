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

    private List<Integer> elements;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return ans;
        Arrays.sort(candidates);
        elements = new ArrayList<>();
        find(candidates, target, 0, false);
        return ans;
    }

    /**
     * @param candidates
     * @param target
     * @param i
     * @param prev 当没选前面且相等时，跳过处理，相当于去重了
     */
    private void find(int[] candidates, int target, int i, boolean prev) {
        if (target == 0) {
            ans.add(new ArrayList<>(elements));
            return;
        }
        if (target < 0 || i == candidates.length || candidates[i] > target) return;
        find(candidates, target, i + 1, false); // 直接处理下一个
        if (prev || i == 0 || candidates[i - 1] < candidates[i]) {
            elements.add(candidates[i]); // 将当前加入
            find(candidates, target - candidates[i], i + 1, true); // 去掉当前值，加下一个
            elements.remove(elements.size() - 1); // 取出新增的元素
        }
    }
}
