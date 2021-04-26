import java.util.ArrayList;
import java.util.List;

/**
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *  输入： nums = [1,2,3]
 *  输出：
 * [
 *  [3],
 *  [1],
 *  [2],
 *  [1,2,3],
 *  [1,3],
 *  [2,3],
 *  [1,2],
 *  []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-set-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00008_04m {

    private List<List<Integer>> ans;

    private List<Integer> temp;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        temp = new ArrayList<>();
        backtrace(nums, 0);
        return ans;
    }

    private void backtrace(int[] nums, int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(temp));
        } else {
            backtrace(nums, i + 1); // 直接取下一个
            temp.add(nums[i]);
            backtrace(nums, i + 1); // 加入当前再取下一个
            temp.remove(temp.size() - 1);
        }
    }
}
