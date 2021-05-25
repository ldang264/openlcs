import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 * 输入:n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 提示:
 * 1 <= n <= 20
 * 1 <= k <= n
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00077m {

    private List<List<Integer>> ans;

    private int[] temp;

    private int idx;

    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        temp = new int[k];
        idx = 0;
        backtrace(n);
        return ans;
    }

    private void backtrace(int i) {
        if (i >= temp.length - idx) { // 剪枝
            backtrace(i - 1); // 直接回溯下一个
            temp[idx++] = i;
            if (idx == temp.length) { // k个数字已满
                List<Integer> list = new ArrayList<>(temp.length);
                for (Integer j : temp) {
                    list.add(j);
                }
                ans.add(list);
            } else {
                backtrace(i - 1); // 继续回溯下一个
            }
            idx--;
        }
    }
}
