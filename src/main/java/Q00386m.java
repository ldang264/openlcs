import java.util.*;

/**
 * 给定一个整数n, 返回从1到n的字典顺序。
 * 例如，给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 * <p>
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据n小于等于5,000,000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lexicographical-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00386m {

    /**
     * 很垃圾很慢
     *
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            ans.add(i);
        }
        Collections.sort(ans, Comparator.comparing(Object::toString));
        return ans;
    }

    public List<Integer> lexicalOrderCompute(int n) {
        List<Integer> ans = new ArrayList<>(n);
        int cur = 1;
        for (int i = 0; i < n; i++) {
            ans.add(cur);
            if (cur * 10 <= n) {
                cur *= 10;
            } else {
                if (cur >= n) cur /= 10;
                cur += 1;
                while (cur % 10 == 0) cur /= 10;
            }
        }
        return ans;
    }

    private List<Integer> ans;

    private int N;

    /**
     * 答案：递归
     *
     * @param n
     * @return
     */
    public List<Integer> lexicalOrderDfs(int n) {
        ans = new ArrayList<>();
        N = n;
        for (int i = 1; i <= 9; i++) {
            dfs(i);
        }
        return ans;
    }

    private void dfs(int i) {
        if (i <= N) {
            ans.add(i);
            i *= 10;
            for (int j = 0; j <= 9; j++) {
                dfs(i + j);
            }
        }
    }

}
