import java.util.ArrayList;
import java.util.Arrays;
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

    private List<Integer> elements;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        elements = new ArrayList<>();
        Arrays.sort(candidates); // 快速排序，元素从小到大
        find(candidates, target, 0);
        return ans;
    }

    /**
     * 回溯
     * @param candidates
     * @param target
     * @param i 数组下标
     */
    private void find(int[] candidates, int target, int i) {
        if (target == 0) {
            ans.add(new ArrayList<>(elements));
            return;
        }
        if (i == candidates.length || candidates[i] > target) return; // 越界处理
        int b = target / candidates[i]; // 余数
        int size = elements.size(); // 存储增加前的大小
        for (int j = 1; j <= b; j++) { // 将当前位置都找干净
            elements.add(candidates[i]);
            find(candidates, target - candidates[i] * j, i + 1); // 找下一位
        }
        while (--b >= 0) { // 将增加的全部都减掉
            elements.remove(size + b);
        }
        find(candidates, target, i + 1); // 当前位置一个都不加，找下一位
    }
}
