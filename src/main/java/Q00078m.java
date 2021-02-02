import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
// 回溯法 TODO
public class Q00078m {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(0)); // 无任何元素[]
        int preSize = 1;
        // 1到nums.length是仅有1个元素的
        for (int num : nums) {
            ans.add(Collections.singletonList(num));
        }
        for (int i = 2; i <= nums.length; i++) { // 将2个及以上的元素放入结果集
            int currentSize = ans.size();
            int j = i - 1;
            for (int k = preSize; k < currentSize; k++) {
                List<Integer> kl = ans.get(k);
                int m = j;
                while (m < nums.length) { // 1个的最小值比i个的最大值大
                    if (nums[m] > kl.get(kl.size() - 1)) {
                        List<Integer> list = new ArrayList<>(kl);
                        list.add(nums[m]);
                        ans.add(list);
                    }
                    m++;
                }
            }
            preSize = currentSize;
        }
        return ans;
    }
}
