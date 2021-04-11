import java.util.ArrayList;
import java.util.List;

/**
 * 统计所有小于非负整数n的质数的数量。
 *
 * 示例 1：
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 *
 * 示例 3：
 * 输入：n = 1
 * 输出：0
 *
 * 提示：
 * 0 <= n <= 5 * 106
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-primes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00204s {

    /**
     * 整个方法效率依然很低，可以研究下答案
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n <= 1) return 0;
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < n; i++) { // 找到质数放入列表
            boolean add = true;
            double sqrt = Math.sqrt(i);
            for (Integer p : primes) {
                if (i % p == 0) {
                    add = false;
                    break;
                }
                if (p >= sqrt) break; // 这一步我一开始没想到，所以超时了，其实只要算到平方根就可以了
            }
            if (add) {
                primes.add(i);
            }
        }
        return primes.size();
    }
}
