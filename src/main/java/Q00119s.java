import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个非负索引k，其中 k≤33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 * 输入: 3
 * 输出: [1,3,3,1]
 *
 * 进阶：
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 *
 * Constraints:
 * 0 <= rowIndex <= 33
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00119s {

    /**
     * 1 x x x x
     * 1 1 x x x
     * 1 2 1 x x
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) return Collections.singletonList(1);
        Integer[] values = new Integer[rowIndex + 1];
        values[0] = values[1] = 1;
        for (int i = 2; i <= rowIndex; i++) {
            values[i] = 1;
            for (int j = i - 1; j >= 1; j--) {
                values[j] += values[j - 1];
            }
        }
        return Arrays.asList(values);
    }
}
