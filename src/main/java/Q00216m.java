import java.util.ArrayList;
import java.util.List;

/**
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 *
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
 *
 * Example 1:
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Explanation:
 * 1 + 2 + 4 = 7
 * There are no other valid combinations.
 *
 * Example 2:
 * Input: k = 3, n = 9
 * Output: [[1,2,6],[1,3,5],[2,3,4]]
 * Explanation:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * There are no other valid combinations.
 *
 * Example 3:
 * Input: k = 4, n = 1
 * Output: []
 * Explanation: There are no valid combinations. [1,2,1] is not valid because 1 is used twice.
 *
 * Example 4:
 * Input: k = 3, n = 2
 * Output: []
 * Explanation: There are no valid combinations.
 *
 * Example 5:
 * Input: k = 9, n = 45
 * Output: [[1,2,3,4,5,6,7,8,9]]
 * Explanation:
 * 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45
 * There are no other valid combinations.
 *
 * Constraints:
 *
 * 2 <= k <= 9
 * 1 <= n <= 60
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00216m {

    private List<List<Integer>> ans;

    private int[] temp;

    private int idx;

    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        temp = new int[k];
        idx = 0;
        backtrace(1, n);
        return ans;
    }

    private void backtrace(int i, int n) {
        if (i == 10 || i > n) return; // 跳出或剪枝
        backtrace(i + 1, n); // 直接跳过
        n -= i;
        temp[idx++] = i;
        if (idx < temp.length) {
            backtrace(i + 1, n); // 还未达到k个数
        } else if (n == 0) { // 满足条件
            List<Integer> list = new ArrayList<>(temp.length);
            for (int num : temp) {
                list.add(num);
            }
            ans.add(list);
        }
        idx--;
    }
}
