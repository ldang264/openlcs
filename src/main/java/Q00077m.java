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

    private List<Integer> temp;

    private int K;

    private int N;

    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        temp = new ArrayList<>();
        K = k;
        N = n;
        for (int i = 1; i <= n + 1 - k; i++) {
            backtrace(i);
        }
        return ans;
    }

    private void backtrace(int i) {
        temp.add(i);
        K--;
        if (K == 0) {
            ans.add(new ArrayList<>(temp));
        } else {
            for (int j = i + 1; j <= N - K + 1; j++) {  // 剪枝，剩余数字要够用
                backtrace(j);
            }
        }
        temp.remove(temp.size() - 1);
        K++;
    }
}
