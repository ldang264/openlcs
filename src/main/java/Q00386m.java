import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数n, 返回从1到n的字典顺序。
 * 例如，给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 *
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据n小于等于5,000,000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lexicographical-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00386m {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        int size = String.valueOf(n).length();
        if (size == 1) {
            for (int i = 1; i <= n; i++) {
                ans.add(i);
            }
        } else {
            for (int i = 1; i <= 9; i++) {
                ans.add(i);
                for (int j = 0; j < size; j++) {

                }
            }

        }
        return ans;
    }
}
