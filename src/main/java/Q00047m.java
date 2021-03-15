import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); // 从小到大排序
        List<List<Integer>> prev = new ArrayList<>();
        prev.add(new ArrayList<>(nums[0]));
        if (nums.length == 1) return prev;
        /*for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1])
                prev.add(new ArrayList<>(nums[i]));
        }*/
        List<List<Integer>> next = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < prev.size(); j++) {

            }
        }
        return next;
    }
}
